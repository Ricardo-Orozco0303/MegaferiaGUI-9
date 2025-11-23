package core.repositories;

import core.models.Manager;
import java.util.Comparator;

public class ManagerRepository extends BaseRepository<Manager, Long> {

    @Override
    protected Long getId(Manager entity) {
        return entity.getId();
    }

    @Override
    protected Comparator<Manager> getComparator() {
        return Comparator.comparingLong(Manager::getId);
    }
}
