package core.controllers;

import core.controllers.dto.AuthorRankingDto;
import core.controllers.dto.BookTableDto;
import core.controllers.interfaces.IQueryController;
import core.controllers.utils.BookMapper;
import core.controllers.utils.MessageUtils;
import core.controllers.utils.Response;
import core.controllers.utils.ResponseFactory;
import core.controllers.utils.ValidationUtils;
import core.models.Author;
import core.models.Book;
import core.repositories.interfaces.IBookRepository;
import core.repositories.interfaces.IRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Controlador para consultas.
 */
public class QueryController implements IQueryController {

    private final IRepository<Author, Long> authorRepo;
    private final IBookRepository bookRepo;

    public QueryController(IRepository<Author, Long> authorRepository, IBookRepository bookRepository) {
        this.authorRepo = authorRepository;
        this.bookRepo = bookRepository;
    }

    @Override
    public Response getBooksByAuthor(String authorId) {
        if (authorId == null) {
            return Response.error(MessageUtils.AUTHOR_ID_NUMERIC);
        }
        
        long parsedId = parseAuthorId(authorId);
        if (parsedId < 0) {
            return Response.error(MessageUtils.AUTHOR_ID_NUMERIC);
        }

        if (!ValidationUtils.isValidId(parsedId)) {
            return Response.error(MessageUtils.AUTHOR_ID_INVALID_RANGE);
        }
        
        Author targetAuthor = authorRepo.findById(parsedId).orElse(null);
        if (targetAuthor == null) {
            return Response.error(MessageUtils.AUTHOR_NOT_FOUND);
        }
        
        List<BookTableDto> matchingBooks = filterBooksBy(
            book -> hasAuthor(book, targetAuthor.getId())
        );
        return ResponseFactory.rows(MessageUtils.QUERY_BOOKS_BY_AUTHOR, matchingBooks);
    }

    @Override
    public Response getBooksByFormat(String format) {
        if (ValidationUtils.isBlank(format)) {
            return Response.error(MessageUtils.FORMAT_REQUIRED);
        }
        
        List<BookTableDto> matchingBooks = filterBooksBy(
            book -> format.equals(book.getFormat())
        );
        return ResponseFactory.rows(MessageUtils.QUERY_BOOKS_BY_FORMAT, matchingBooks);
    }

    @Override
    public Response getAuthorsWithMorePublishers() {
        int maximumPublisherCount = determineMaxPublisherCount();
        List<AuthorRankingDto> topAuthors = collectAuthorsWithPublisherCount(maximumPublisherCount);
        topAuthors.sort(Comparator.comparingLong(AuthorRankingDto::getId));
        
        return ResponseFactory.rows(MessageUtils.QUERY_AUTHORS_TOP, topAuthors);
    }

    private long parseAuthorId(String idText) {
        try {
            return Long.parseLong(idText.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean hasAuthor(Book book, long authorId) {
        return book.getAuthors()
                .stream()
                .anyMatch(author -> author.getId() == authorId);
    }

    private List<BookTableDto> filterBooksBy(Predicate<Book> criteria) {
        return bookRepo.findAllOrdered()
                .stream()
                .filter(criteria)
                .map(BookMapper::toTableDto)
                .sorted(Comparator.comparing(BookTableDto::getIsbn))
                .collect(Collectors.toList());
    }

    private int determineMaxPublisherCount() {
        int maximum = -1;
        for (Author author : authorRepo.findAllOrdered()) {
            int count = author.getPublisherQuantity();
            if (count > maximum) {
                maximum = count;
            }
        }
        return maximum;
    }

    private List<AuthorRankingDto> collectAuthorsWithPublisherCount(int targetCount) {
        List<AuthorRankingDto> qualifyingAuthors = new ArrayList<>();
        
        if (targetCount < 0) {
            return qualifyingAuthors;
        }
        
        for (Author author : authorRepo.findAllOrdered()) {
            if (author.getPublisherQuantity() == targetCount) {
                qualifyingAuthors.add(new AuthorRankingDto(
                    author.getId(), 
                    author.getFullname(), 
                    targetCount
                ));
            }
        }
        
        return qualifyingAuthors;
    }
}
