package core.controllers.utils;

import core.controllers.BookController;
import core.controllers.PersonController;
import core.controllers.PublisherController;
import core.controllers.PurchaseController;
import core.controllers.QueryController;
import core.controllers.StandController;
import core.controllers.ResponseProcessor;
import core.controllers.handlers.ErrorHandler;
import core.controllers.handlers.FormHandler;
import core.controllers.handlers.MessageHandler;
import core.controllers.handlers.RefreshDataHandler;
import core.controllers.handlers.SelectionHandler;
import core.controllers.interfaces.IBookController;
import core.controllers.interfaces.IPersonController;
import core.controllers.interfaces.IPublisherController;
import core.controllers.interfaces.IPurchaseController;
import core.controllers.interfaces.IQueryController;
import core.controllers.interfaces.IStandController;
import core.models.Author;
import core.models.Manager;
import core.models.Narrator;
import core.models.Stand;
import core.models.factory.ModelFactoryManager;
import core.observer.DataChangeNotifier;
import core.repositories.AuthorRepository;
import core.repositories.BookRepository;
import core.repositories.ManagerRepository;
import core.repositories.NarratorRepository;
import core.repositories.PublisherRepository;
import core.repositories.StandRepository;
import core.repositories.interfaces.IBookRepository;
import core.repositories.interfaces.IPublisherRepository;
import core.repositories.interfaces.IRepository;
import core.views.MegaferiaFrame;

/**
 * Actúa inyector de dependencias.
 */
public class DependencyInjector {

    private MegaferiaFrame applicationView;
    private ErrorHandler errorHandler;
    private MessageHandler messageHandler;
    private FormHandler formHandler;
    private RefreshDataHandler refreshDataHandler;
    private SelectionHandler selectionHandler;
    private ResponseProcessor responseProcessor;

    public DependencyInjector initialize() {
        StandRepository standRepo = new StandRepository();
        AuthorRepository authorRepo = new AuthorRepository();
        ManagerRepository managerRepo = new ManagerRepository();
        NarratorRepository narratorRepo = new NarratorRepository();
        PublisherRepository publisherRepo = new PublisherRepository();
        BookRepository bookRepo = new BookRepository();
        DataChangeNotifier changeNotifier = new DataChangeNotifier();

        ModelFactoryManager factoryManager = new ModelFactoryManager();
        
        // Construct business logic controllers
        IStandController standCtrl = assembleStandController(standRepo, factoryManager, changeNotifier);
        IPersonController personCtrl = assemblePersonController(authorRepo, managerRepo, narratorRepo, factoryManager, changeNotifier);
        IPublisherController publisherCtrl = assemblePublisherController(publisherRepo, managerRepo, factoryManager, changeNotifier);
        IBookController bookCtrl = assembleBookController(bookRepo, authorRepo, publisherRepo, narratorRepo, factoryManager, changeNotifier);
        IPurchaseController purchaseCtrl = assemblePurchaseController(standRepo, publisherRepo, factoryManager, changeNotifier);
        IQueryController queryCtrl = assembleQueryController(authorRepo, bookRepo);
        
        setupUserInterfaceHandlers();
        
        this.applicationView = new MegaferiaFrame(
                standCtrl,
                personCtrl,
                publisherCtrl,
                bookCtrl,
                purchaseCtrl,
                queryCtrl,
                changeNotifier,
                errorHandler,
                messageHandler,
                formHandler,
                refreshDataHandler,
                responseProcessor,
                selectionHandler
        );
        
        return this;
    }

    private IStandController assembleStandController(IRepository<Stand, Long> standRepo, 
            ModelFactoryManager factories, DataChangeNotifier notifier) {
        return new StandController(standRepo, factories.getStandFactory(), notifier);
    }

    private IPersonController assemblePersonController(IRepository<Author, Long> authorRepo,
            IRepository<Manager, Long> managerRepo, IRepository<Narrator, Long> narratorRepo,
            ModelFactoryManager factories, DataChangeNotifier notifier) {
        return new PersonController(authorRepo, managerRepo, narratorRepo, 
                factories.getPersonFactory(), notifier);
    }

    private IPublisherController assemblePublisherController(IPublisherRepository publisherRepo,
            IRepository<Manager, Long> managerRepo, ModelFactoryManager factories, 
            DataChangeNotifier notifier) {
        return new PublisherController(publisherRepo, managerRepo, 
                factories.getPublisherFactory(), notifier);
    }

    private IBookController assembleBookController(IBookRepository bookRepo,
            IRepository<Author, Long> authorRepo, IPublisherRepository publisherRepo,
            IRepository<Narrator, Long> narratorRepo, ModelFactoryManager factories,
            DataChangeNotifier notifier) {
        return new BookController(bookRepo, authorRepo, publisherRepo, 
                narratorRepo, factories.getBookFactory(), notifier);
    }

    private IPurchaseController assemblePurchaseController(IRepository<Stand, Long> standRepo,
            IPublisherRepository publisherRepo, ModelFactoryManager factories,
            DataChangeNotifier notifier) {
        return new PurchaseController(standRepo, publisherRepo, 
                factories.getPublisherAssignmentFactory(), notifier);
    }

    private IQueryController assembleQueryController(IRepository<Author, Long> authorRepo,
            IBookRepository bookRepo) {
        return new QueryController(authorRepo, bookRepo);
    }

    private void setupUserInterfaceHandlers() {
        this.errorHandler = new ErrorHandler();
        this.messageHandler = new MessageHandler(errorHandler);
        this.formHandler = new FormHandler();
        this.refreshDataHandler = new RefreshDataHandler();
        this.selectionHandler = new SelectionHandler();
        this.responseProcessor = new ResponseProcessor(messageHandler);
    }

    public MegaferiaFrame getMainFrame() {
        return applicationView;
    }

    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public FormHandler getFormHandler() {
        return formHandler;
    }

    public RefreshDataHandler getRefreshDataHandler() {
        return refreshDataHandler;
    }

    public SelectionHandler getSelectionHandler() {
        return selectionHandler;
    }

    public ResponseProcessor getResponseProcessor() {
        return responseProcessor;
    }
}
