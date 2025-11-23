package core.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación base para observadores
 */
public abstract class AbstractObservable implements IObservable {

    private final List<IObserver> registeredObservers = new ArrayList<>();

    @Override
    public void addObserver(IObserver observer) {
        if (isInvalidObserver(observer)) {
            return;
        }
        registeredObservers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        registeredObservers.remove(observer);
    }

    @Override
    public void notifyObservers(DataChangeEvent event) {
        List<IObserver> observerSnapshot = createObserverSnapshot();
        broadcastEventToObservers(observerSnapshot, event);
    }

    private boolean isInvalidObserver(IObserver observer) {
        return observer == null || registeredObservers.contains(observer);
    }

    private List<IObserver> createObserverSnapshot() {
        return new ArrayList<>(registeredObservers);
    }

    private void broadcastEventToObservers(List<IObserver> observers, DataChangeEvent event) {
        for (IObserver observer : observers) {
            observer.update(event);
        }
    }
}
