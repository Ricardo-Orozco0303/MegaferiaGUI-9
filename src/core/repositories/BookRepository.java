package core.repositories;

import core.models.Book;
import core.repositories.interfaces.IBookRepository;
import java.util.Comparator;
import java.util.Optional;

public class BookRepository extends BaseRepository<Book, String> implements IBookRepository {

    @Override
    protected String getId(Book entity) {
        return entity.getIsbn();
    }

    @Override
    protected Comparator<Book> getComparator() {
        return Comparator.comparing(Book::getIsbn);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return findById(isbn);
    }
}
