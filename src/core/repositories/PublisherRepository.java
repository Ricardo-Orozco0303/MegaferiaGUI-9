package core.repositories;

import core.models.Publisher;
import core.repositories.interfaces.IPublisherRepository;
import java.util.Comparator;
import java.util.Optional;

public class PublisherRepository extends BaseRepository<Publisher, String> implements IPublisherRepository {

    @Override
    protected String getId(Publisher entity) {
        return entity.getNit();
    }

    @Override
    protected Comparator<Publisher> getComparator() {
        return Comparator.comparing(Publisher::getNit);
    }

    @Override
    public Optional<Publisher> findByNit(String nit) {
        return findById(nit);
    }
}
