package core.models.factory;

import core.models.Manager;
import core.models.Publisher;

/**
 * Creación de objetos Publisher.
 */
public class PublisherFactory {

    public Publisher createPublisher(String nit, String name, String address, Manager manager) {
        return new Publisher(
                nit,
                name,
                address,
                manager
        );
    }
}
