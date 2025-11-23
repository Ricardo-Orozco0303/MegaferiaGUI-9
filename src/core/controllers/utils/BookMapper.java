package core.controllers.utils;

import core.controllers.dto.BookTableDto;
import core.models.Audiobook;
import core.models.Book;
import core.models.DigitalBook;
import core.models.PrintedBook;
import java.util.stream.Collectors;

/**
 * Mapper para convertir libros a DTOs.
 */
public final class BookMapper {

    private static final String EMPTY_FIELD_MARKER = "-";
    private static final String AUTHOR_SEPARATOR = ", ";
    private static final String NO_HYPERLINK_TEXT = "No";

    private BookMapper() {
    }

    public static BookTableDto toTableDto(Book book) {
        String authorNames = formatAuthorList(book);
        
        if (book instanceof PrintedBook) {
            return mapPrintedBook((PrintedBook) book, authorNames);
        }
        if (book instanceof DigitalBook) {
            return mapDigitalBook((DigitalBook) book, authorNames);
        }
        if (book instanceof Audiobook) {
            return mapAudiobook((Audiobook) book, authorNames);
        }
        
        throw new IllegalStateException("Encountered unknown book type: " + book.getClass().getSimpleName());
    }

    private static String formatAuthorList(Book book) {
        String concatenatedAuthors = book.getAuthors()
                .stream()
                .map(author -> author.getFullname())
                .collect(Collectors.joining(AUTHOR_SEPARATOR));
        
        return concatenatedAuthors.isEmpty() ? EMPTY_FIELD_MARKER : concatenatedAuthors;
    }

    private static BookTableDto mapPrintedBook(PrintedBook book, String authors) {
        return new BookTableDto(
                book.getTitle(),
                authors,
                book.getIsbn(),
                book.getGenre(),
                book.getFormat(),
                book.getValue(),
                book.getPublisher().getName(),
                String.valueOf(book.getCopies()),
                String.valueOf(book.getPages()),
                EMPTY_FIELD_MARKER,
                EMPTY_FIELD_MARKER,
                EMPTY_FIELD_MARKER
        );
    }

    private static BookTableDto mapDigitalBook(DigitalBook book, String authors) {
        String hyperlinkDisplay = book.hasHyperlink() ? book.getHyperlink() : NO_HYPERLINK_TEXT;
        
        return new BookTableDto(
                book.getTitle(),
                authors,
                book.getIsbn(),
                book.getGenre(),
                book.getFormat(),
                book.getValue(),
                book.getPublisher().getName(),
                EMPTY_FIELD_MARKER,
                EMPTY_FIELD_MARKER,
                hyperlinkDisplay,
                EMPTY_FIELD_MARKER,
                EMPTY_FIELD_MARKER
        );
    }

    private static BookTableDto mapAudiobook(Audiobook book, String authors) {
        return new BookTableDto(
                book.getTitle(),
                authors,
                book.getIsbn(),
                book.getGenre(),
                book.getFormat(),
                book.getValue(),
                book.getPublisher().getName(),
                EMPTY_FIELD_MARKER,
                EMPTY_FIELD_MARKER,
                EMPTY_FIELD_MARKER,
                book.getNarrador().getFullname(),
                String.valueOf(book.getDuration())
        );
    }
}

