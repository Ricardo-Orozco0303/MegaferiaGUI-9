package core.repositories;

import core.repositories.interfaces.IRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Repositorio base con implementación genérica de operaciones CRUD.
 */
public abstract class BaseRepository<T, ID> implements IRepository<T, ID> {

    protected final Map<ID, T> inMemoryStorage = new HashMap<>();

    /**
     * Extrae el ID de la entidad.
     */
    protected abstract ID getId(T entity);

    /**
     * Obtiene el comparador para ordenar los resultados.
     */
    protected abstract Comparator<T> getComparator();

    @Override
    public boolean exists(ID id) {
        return inMemoryStorage.containsKey(id);
    }

    @Override
    public void save(T entity) {
        ID entityKey = getId(entity);
        inMemoryStorage.put(entityKey, entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        T foundEntity = inMemoryStorage.get(id);
        return Optional.ofNullable(foundEntity);
    }

    @Override
    public List<T> findAllOrdered() {
        List<T> allEntities = new ArrayList<>(inMemoryStorage.values());
        allEntities.sort(getComparator());
        return allEntities;
    }
}

