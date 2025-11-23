package core.models.factory;

import core.models.Publisher;
import core.models.Stand;

/**
 * Maneja asociaciones entre stands y editoriales
 */
public class PublisherAssignmentFactory {

    public void link(Stand stand, Publisher publisher) {
        if (!isStandAlreadyLinkedToPublisher(stand, publisher)) {
            stand.addPublisher(publisher);
        }
        if (!isPublisherAlreadyLinkedToStand(publisher, stand)) {
            publisher.addStand(stand);
        }
    }

    private boolean isStandAlreadyLinkedToPublisher(Stand stand, Publisher publisher) {
        return stand.getPublishers().contains(publisher);
    }

    private boolean isPublisherAlreadyLinkedToStand(Publisher publisher, Stand stand) {
        return publisher.getStands().contains(stand);
    }
}

