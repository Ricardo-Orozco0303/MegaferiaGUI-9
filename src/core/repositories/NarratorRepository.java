package core.repositories;

import core.models.Narrator;
import java.util.Comparator;

public class NarratorRepository extends BaseRepository<Narrator, Long> {

    @Override
    protected Long getId(Narrator entity) {
        return entity.getId();
    }

    @Override
    protected Comparator<Narrator> getComparator() {
        return Comparator.comparingLong(Narrator::getId);
    }
}
