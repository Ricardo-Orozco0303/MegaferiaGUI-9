package core.controllers.strategies;

import core.controllers.dto.BookCreationRequest;
import core.models.Author;
import core.models.Book;
import core.models.Publisher;
import core.models.factory.BookFactory;
import java.util.List;

/**
 * Estrategia para la creación de libros según su tipo.
 */
public interface BookCreationStrategy {
    
    /**
     * Crea un libro validando sus atributos específicos.
     */
    Book create(BookCreationRequest request, 
                List<Author> authors, 
                Publisher publisher, 
                double price, 
                BookFactory factory);
}

