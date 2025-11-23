package core.controllers;

import core.controllers.dto.PublisherCreationRequest;
import core.controllers.dto.PublisherTableDto;
import core.controllers.dto.SelectionOptionDto;
import core.controllers.interfaces.IPublisherController;
import core.controllers.utils.MessageUtils;
import core.controllers.utils.PublisherMapper;
import core.controllers.utils.Response;
import core.controllers.utils.ResponseFactory;
import core.controllers.utils.ValidationUtils;
import core.models.Manager;
import core.models.Publisher;
import core.models.factory.PublisherFactory;
import core.observer.DataChangeNotifier;
import core.observer.DataChangeType;
import core.repositories.interfaces.IPublisherRepository;
import core.repositories.interfaces.IRepository;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para editoriales.
 */
public class PublisherController implements IPublisherController {

    private final IPublisherRepository publisherRepo;
    private final IRepository<Manager, Long> managerRepo;
    private final PublisherFactory factory;
    private final DataChangeNotifier changeNotifier;

    public PublisherController(IPublisherRepository publisherRepository,
            IRepository<Manager, Long> managerRepository,
            PublisherFactory publisherFactory,
            DataChangeNotifier notifier) {
        this.publisherRepo = publisherRepository;
        this.managerRepo = managerRepository;
        this.factory = publisherFactory;
        this.changeNotifier = notifier;
    }

    @Override
    public Response createPublisher(PublisherCreationRequest request) {
        long managerId = parseManagerId(request.getManagerId());
        if (managerId < 0) {
            return Response.error(MessageUtils.ID_MANAGER_INVALID);
        }

        Response dataValidation = validatePublisherData(request);
        if (!dataValidation.isSuccess()) {
            return dataValidation;
        }
        
        Manager assignedManager = managerRepo.findById(managerId).orElse(null);
        Response managerValidation = validateManager(assignedManager);
        if (!managerValidation.isSuccess()) {
            return managerValidation;
        }
        
        Publisher newPublisher = factory.createPublisher(
                request.getNit(), 
                request.getName(), 
                request.getAddress(), 
                assignedManager
        );
        
        assignedManager.setPublisher(newPublisher);
        managerRepo.save(assignedManager);
        
        persistPublisher(newPublisher);
        changeNotifier.emit(DataChangeType.PERSONS);
        
        return Response.success(MessageUtils.PUBLISHER_CREATED);
    }

    @Override
    public Response getPublisherOptions() {
        List<SelectionOptionDto> publisherChoices = publisherRepo.findAllOrdered()
                .stream()
                .map(PublisherMapper::toSelectionDto)
                .collect(Collectors.toList());
        return ResponseFactory.options("Editoriales disponibles", publisherChoices);
    }

    @Override
    public Response getPublisherTable() {
        List<PublisherTableDto> tableRows = publisherRepo.findAllOrdered()
                .stream()
                .map(PublisherMapper::toTableDto)
                .collect(Collectors.toList());
        return ResponseFactory.rows("Tabla de editoriales", tableRows);
    }

    private long parseManagerId(String idText) {
        try {
            return Long.parseLong(idText);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private Response validatePublisherData(PublisherCreationRequest request) {
        if (ValidationUtils.isBlank(request.getNit()) || 
            !ValidationUtils.isValidNit(request.getNit())) {
            return Response.error(MessageUtils.NIT_INVALID_FORMAT);
        }
        if (ValidationUtils.isBlank(request.getName()) || 
            ValidationUtils.isBlank(request.getAddress())) {
            return Response.error(MessageUtils.NAME_ADDRESS_REQUIRED);
        }
        if (publisherRepo.exists(request.getNit())) {
            return Response.error(MessageUtils.NIT_EXISTS);
        }
        return Response.success("");
    }

    private Response validateManager(Manager manager) {
        if (manager == null) {
            return Response.error(MessageUtils.MANAGER_NOT_FOUND);
        }
        if (manager.getPublisher() != null) {
            return Response.error(MessageUtils.MANAGER_ASSIGNED);
        }
        return Response.success("");
    }

    private void persistPublisher(Publisher publisher) {
        publisherRepo.save(publisher);
        changeNotifier.emit(DataChangeType.PUBLISHERS);
    }
}
