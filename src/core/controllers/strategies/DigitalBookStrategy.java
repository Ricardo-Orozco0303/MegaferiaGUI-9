package core.controllers.strategies;

import core.controllers.dto.BookCreationRequest;
import core.models.Author;
import core.models.Book;
import core.models.Publisher;
import core.models.factory.BookFactory;
import java.util.List;

public class DigitalBookStrategy implements BookCreationStrategy {

    @Override
    public Book create(BookCreationRequest request, List<Author> authors, Publisher publisher, 
                       double price, BookFactory factory) {
        return factory.createDigitalBook(
                request.getTitle(),
                authors,
                request.getIsbn(),
                request.getGenre(),
                request.getFormat(),
                price,
                publisher,
                request.getHyperlink()
        );
    }
}

