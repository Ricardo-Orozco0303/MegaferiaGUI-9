package core.controllers;

import core.controllers.dto.BookCreationRequest;
import core.controllers.dto.BookTableDto;
import core.controllers.dto.BookType;
import core.controllers.interfaces.IBookController;
import core.controllers.strategies.AudiobookStrategy;
import core.controllers.strategies.BookCreationStrategy;
import core.controllers.strategies.DigitalBookStrategy;
import core.controllers.strategies.PrintedBookStrategy;
import core.controllers.utils.BookMapper;
import core.controllers.utils.MessageUtils;
import core.controllers.utils.Response;
import core.controllers.utils.ResponseFactory;
import core.controllers.utils.ValidationUtils;
import core.models.Author;
import core.models.Audiobook;
import core.models.Book;
import core.models.DigitalBook;
import core.models.Narrator;
import core.models.PrintedBook;
import core.models.Publisher;
import core.models.factory.BookFactory;
import core.observer.DataChangeNotifier;
import core.observer.DataChangeType;
import core.repositories.interfaces.IBookRepository;
import core.repositories.interfaces.IPublisherRepository;
import core.repositories.interfaces.IRepository;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Controlador para los libros.
 */
public class BookController implements IBookController {

    private final IBookRepository bookRepo;
    private final IRepository<Author, Long> authorRepo;
    private final IPublisherRepository publisherRepo;
    private final IRepository<Narrator, Long> narratorRepo;
    private final DataChangeNotifier changeNotifier;
    private final BookFactory factory;
    private final Map<BookType, BookCreationStrategy> creationStrategies;

    public BookController(IBookRepository bookRepository,
            IRepository<Author, Long> authorRepository,
            IPublisherRepository publisherRepository,
            IRepository<Narrator, Long> narratorRepository,
            BookFactory bookFactory,
            DataChangeNotifier notifier) {
        this.bookRepo = bookRepository;
        this.authorRepo = authorRepository;
        this.publisherRepo = publisherRepository;
        this.narratorRepo = narratorRepository;
        this.factory = bookFactory;
        this.changeNotifier = notifier;
        this.creationStrategies = initializeCreationStrategies(narratorRepository);
    }

    @Override
    public Response createBook(BookCreationRequest request) {
        double bookPrice = parsePrice(request.getPrice());
        if (bookPrice < 0) {
            return Response.error(MessageUtils.PRICE_BOOK_VALID);
        }

        Response commonValidation = validateCommonBookData(request, bookPrice);
        if (!commonValidation.isSuccess()) {
            return commonValidation;
        }
        
        List<Long> authorIdentifiers = parseAuthorIds(request.getAuthorIds());
        if (authorIdentifiers == null) {
            return Response.error(MessageUtils.AUTHOR_ID_INVALID);
        }
        
        Response authorValidation = validateAuthors(authorIdentifiers);
        if (!authorValidation.isSuccess()) {
            return authorValidation;
        }

        List<Author> bookAuthors = retrieveAuthors(authorIdentifiers);
        Publisher bookPublisher = publisherRepo.findByNit(request.getPublisherNit()).orElse(null);
        if (bookPublisher == null) {
            return Response.error(MessageUtils.PUBLISHER_NOT_FOUND);
        }
        
        return executeBookCreation(request, bookAuthors, bookPublisher, bookPrice);
    }

    @Override
    public Response getBooksByType(BookType type) {
        List<BookTableDto> matchingBooks = new ArrayList<>();
        for (Book book : bookRepo.findAllOrdered()) {
            if (isOfType(book, type)) {
                matchingBooks.add(BookMapper.toTableDto(book));
            }
        }
        return ResponseFactory.rows("Listado de libros", matchingBooks);
    }

    @Override
    public Response getAllBooks() {
        List<BookTableDto> allBookRows = new ArrayList<>();
        for (Book book : bookRepo.findAllOrdered()) {
            allBookRows.add(BookMapper.toTableDto(book));
        }
        return ResponseFactory.rows("Listado de libros", allBookRows);
    }

    private Map<BookType, BookCreationStrategy> initializeCreationStrategies(
            IRepository<Narrator, Long> narratorRepo) {
        Map<BookType, BookCreationStrategy> strategies = new EnumMap<>(BookType.class);
        strategies.put(BookType.PRINTED, new PrintedBookStrategy());
        strategies.put(BookType.DIGITAL, new DigitalBookStrategy());
        strategies.put(BookType.AUDIOBOOK, new AudiobookStrategy(narratorRepo));
        return strategies;
    }

    private double parsePrice(String priceText) {
        try {
            return Double.parseDouble(priceText.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private Response validateCommonBookData(BookCreationRequest request, double price) {
        if (!ValidationUtils.isPositive(price)) {
            return Response.error(MessageUtils.PRICE_BOOK_POSITIVE);
        }
        if (ValidationUtils.isBlank(request.getTitle())) {
            return Response.error(MessageUtils.TITLE_REQUIRED);
        }
        if (ValidationUtils.isBlank(request.getIsbn()) || 
            !ValidationUtils.isValidIsbn(request.getIsbn())) {
            return Response.error(MessageUtils.ISBN_INVALID);
        }
        if (bookRepo.exists(request.getIsbn())) {
            return Response.error(MessageUtils.ISBN_EXISTS);
        }
        return Response.success("");
    }

    private List<Long> parseAuthorIds(List<String> authorIdStrings) {
        if (authorIdStrings == null || authorIdStrings.isEmpty()) {
            return null;
        }
        try {
            List<Long> parsedIds = new ArrayList<>();
            for (String idText : authorIdStrings) {
                parsedIds.add(Long.parseLong(idText.trim()));
            }
            return parsedIds;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Response validateAuthors(List<Long> authorIds) {
        if (authorIds == null || authorIds.isEmpty()) {
            return Response.error(MessageUtils.AUTHOR_REQUIRED);
        }
        
        Set<Long> uniqueAuthorIds = new HashSet<>(authorIds);
        if (uniqueAuthorIds.size() != authorIds.size()) {
            return Response.error(MessageUtils.AUTHOR_DUPLICATE);
        }
        
        return Response.success("");
    }

    private List<Author> retrieveAuthors(List<Long> authorIds) {
        List<Author> foundAuthors = new ArrayList<>();
        for (Long authorId : authorIds) {
            Author author = authorRepo.findById(authorId).orElse(null);
            if (author != null) {
                foundAuthors.add(author);
            }
        }
        return foundAuthors;
    }

    private Response executeBookCreation(BookCreationRequest request, List<Author> authors, 
                                        Publisher publisher, double price) {
        if (request.getType() == null) {
            return Response.error(MessageUtils.TYPE_REQUIRED);
        }
        
        BookCreationStrategy strategy = creationStrategies.get(request.getType());
        if (strategy == null) {
            return Response.error(MessageUtils.TYPE_NOT_SUPPORTED);
        }

        try {
            Book newBook = strategy.create(request, authors, publisher, price, factory);
            persistBook(newBook);
            return Response.success(MessageUtils.BOOK_CREATED);
        } catch (IllegalArgumentException e) {
            return Response.error(e.getMessage());
        }
    }

    private void persistBook(Book book) {
        bookRepo.save(book);
        
        for (core.models.interfaces.IAuthor iAuthor : book.getAuthors()) {
            if (iAuthor instanceof Author author) {
                authorRepo.save(author);
            }
        }
        
        if (book instanceof Audiobook audiobook) {
            Narrator narrator = audiobook.getNarrador();
            if (narrator != null) {
                narratorRepo.save(narrator);
            }
        }
        
        changeNotifier.emit(DataChangeType.BOOKS);
        changeNotifier.emit(DataChangeType.PERSONS);
    }

    private boolean isOfType(Book book, BookType targetType) {
        return switch (targetType) {
            case PRINTED -> book instanceof PrintedBook;
            case DIGITAL -> book instanceof DigitalBook;
            case AUDIOBOOK -> book instanceof Audiobook;
            default -> false;
        };
    }
}
