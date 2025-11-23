package core.models.factory;

/**
 * Central para acceder a las fábricas de modelos
 */
public class ModelFactoryManager {

    private final BookFactory bookCreator = new BookFactory();
    private final PersonFactory personCreator = new PersonFactory();
    private final StandFactory standCreator = new StandFactory();
    private final PublisherFactory publisherCreator = new PublisherFactory();
    private final PublisherAssignmentFactory relationshipManager = new PublisherAssignmentFactory();

    public BookFactory getBookFactory() {
        return bookCreator;
    }

    public PersonFactory getPersonFactory() {
        return personCreator;
    }

    public StandFactory getStandFactory() {
        return standCreator;
    }

    public PublisherFactory getPublisherFactory() {
        return publisherCreator;
    }

    public PublisherAssignmentFactory getPublisherAssignmentFactory() {
        return relationshipManager;
    }
}

