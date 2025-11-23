package core.repositories;

import core.models.Stand;
import java.util.Comparator;

public class StandRepository extends BaseRepository<Stand, Long> {

    @Override
    protected Long getId(Stand entity) {
        return entity.getId();
    }

    @Override
    protected Comparator<Stand> getComparator() {
        return Comparator.comparingLong(Stand::getId);
    }
}
