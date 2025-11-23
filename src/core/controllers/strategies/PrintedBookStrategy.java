package core.controllers.strategies;

import core.controllers.dto.BookCreationRequest;
import core.controllers.utils.MessageUtils;
import core.models.Author;
import core.models.Book;
import core.models.Publisher;
import core.models.factory.BookFactory;
import java.util.List;

public class PrintedBookStrategy implements BookCreationStrategy {

    @Override
    public Book create(BookCreationRequest request, List<Author> authors, Publisher publisher, 
                       double price, BookFactory factory) {
        int pageCount = extractPageCount(request.getPages());
        int copyQuantity = extractCopyCount(request.getCopies());
        
        validatePhysicalAttributes(pageCount, copyQuantity);

        return factory.createPrintedBook(
                request.getTitle(),
                authors,
                request.getIsbn(),
                request.getGenre(),
                request.getFormat(),
                price,
                publisher,
                pageCount,
                copyQuantity
        );
    }

    private int extractPageCount(String pagesText) {
        try {
            return Integer.parseInt(pagesText.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageUtils.PAGES_COPIES_INTEGER);
        }
    }

    private int extractCopyCount(String copiesText) {
        try {
            return Integer.parseInt(copiesText.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageUtils.PAGES_COPIES_INTEGER);
        }
    }

    private void validatePhysicalAttributes(int pages, int copies) {
        if (pages <= 0 || copies <= 0) {
            throw new IllegalArgumentException(MessageUtils.PAGES_COPIES_POSITIVE);
        }
    }
}

