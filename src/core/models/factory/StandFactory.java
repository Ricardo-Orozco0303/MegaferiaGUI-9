package core.models.factory;

import core.models.Stand;

/**
 * Para crear stands.
 */
public class StandFactory {

    public Stand createStand(long id, double price) {
        return new Stand(id, price);
    }
}
