package core.models;

import core.models.interfaces.IManager;
import core.models.interfaces.IPublisher;

/**
 *
 * @author edangulo
 */
public class Manager extends Person implements IManager {

    private Publisher assignedPublisher;

    public Manager(long id, String firstname, String lastname) {
        super(id, firstname, lastname);
        this.assignedPublisher = null;
    }

    @Override
    public IPublisher getPublisher() {
        return assignedPublisher;
    }

    public void setPublisher(Publisher publisher) {
        this.assignedPublisher = publisher;
    }
}
