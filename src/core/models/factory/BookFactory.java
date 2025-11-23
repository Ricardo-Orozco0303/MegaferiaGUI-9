package core.models.factory;

import core.models.Author;
import core.models.Audiobook;
import core.models.DigitalBook;
import core.models.Narrator;
import core.models.PrintedBook;
import core.models.Publisher;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class BookFactory {

    public PrintedBook createPrintedBook(
            String title,
            List<Author> authors,
            String isbn,
            String genre,
            String format,
            double price,
            Publisher publisher,
            int pages,
            int copies) {
        
        return new PrintedBook(
                title,
                createAuthorCopy(authors),
                isbn,
                genre,
                format,
                price,
                publisher,
                pages,
                copies
        );
    }

    public DigitalBook createDigitalBook(
            String title,
            List<Author> authors,
            String isbn,
            String genre,
            String format,
            double price,
            Publisher publisher,
            String hyperlink) {

        ArrayList<Author> authorsCopy = createAuthorCopy(authors);
        
        if (hasValidHyperlink(hyperlink)) {
            return new DigitalBook(title, authorsCopy, isbn, genre, format, price, publisher, hyperlink);
        }
        
        return new DigitalBook(title, authorsCopy, isbn, genre, format, price, publisher);
    }

    public Audiobook createAudiobook(
            String title,
            List<Author> authors,
            String isbn,
            String genre,
            String format,
            double price,
            Publisher publisher,
            int duration,
            Narrator narrator) {

        return new Audiobook(
                title,
                createAuthorCopy(authors),
                isbn,
                genre,
                format,
                price,
                publisher,
                duration,
                narrator
        );
    }

    private ArrayList<Author> createAuthorCopy(List<Author> authors) {
        return new ArrayList<>(authors);
    }

    private boolean hasValidHyperlink(String hyperlink) {
        return hyperlink != null && !hyperlink.isBlank();
    }
}
