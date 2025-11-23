package core.repositories;

import core.models.Author;
import java.util.Comparator;

public class AuthorRepository extends BaseRepository<Author, Long> {

    @Override
    protected Long getId(Author entity) {
        return entity.getId();
    }

    @Override
    protected Comparator<Author> getComparator() {
        return Comparator.comparingLong(Author::getId);
    }
}
