package core.observer;

/**
 * Evento que indica qué tipo de dato cambió
 */
public class DataChangeEvent {

    private final DataChangeType changeCategory;

    public DataChangeEvent(DataChangeType type) {
        this.changeCategory = type;
    }

    public DataChangeType getType() {
        return changeCategory;
    }
}
