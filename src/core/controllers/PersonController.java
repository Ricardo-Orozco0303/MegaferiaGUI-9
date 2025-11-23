package core.controllers;

import core.controllers.dto.PersonCreationRequest;
import core.controllers.dto.PersonTableDto;
import core.controllers.dto.SelectionOptionDto;
import core.controllers.interfaces.IPersonController;
import core.controllers.utils.MessageUtils;
import core.controllers.utils.PersonMapper;
import core.controllers.utils.Response;
import core.controllers.utils.ResponseFactory;
import core.controllers.utils.ValidationUtils;
import core.models.Author;
import core.models.Manager;
import core.models.Narrator;
import core.models.factory.PersonFactory;
import core.observer.DataChangeNotifier;
import core.observer.DataChangeType;
import core.repositories.interfaces.IRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para personas (autores, gerentes y narradores).
 */
public class PersonController implements IPersonController {

    private final IRepository<Author, Long> authorRepo;
    private final IRepository<Manager, Long> managerRepo;
    private final IRepository<Narrator, Long> narratorRepo;
    private final PersonFactory factory;
    private final DataChangeNotifier changeNotifier;

    public PersonController(
            IRepository<Author, Long> authorRepository,
            IRepository<Manager, Long> managerRepository,
            IRepository<Narrator, Long> narratorRepository,
            PersonFactory personFactory,
            DataChangeNotifier notifier) {
        this.authorRepo = authorRepository;
        this.managerRepo = managerRepository;
        this.narratorRepo = narratorRepository;
        this.factory = personFactory;
        this.changeNotifier = notifier;
    }

    @Override
    public Response createPerson(PersonCreationRequest request) {
        long personId = parsePersonId(request.getId());
        if (personId < 0) {
            return Response.error(MessageUtils.ID_PERSON_INTEGER);
        }

        Response validationResponse = validatePersonData(personId, request);
        if (!validationResponse.isSuccess()) {
            return validationResponse;
        }
        
        return persistPersonByRole(request, personId);
    }

    @Override
    public Response getAuthorOptions() {
        List<SelectionOptionDto> authorChoices = authorRepo.findAllOrdered()
                .stream()
                .map(PersonMapper::toSelectionDto)
                .collect(Collectors.toList());
        return ResponseFactory.options("Autores disponibles", authorChoices);
    }

    @Override
    public Response getManagerOptions() {
        List<SelectionOptionDto> managerChoices = managerRepo.findAllOrdered()
                .stream()
                .map(PersonMapper::toSelectionDto)
                .collect(Collectors.toList());
        return ResponseFactory.options("Gerentes disponibles", managerChoices);
    }

    @Override
    public Response getNarratorOptions() {
        List<SelectionOptionDto> narratorChoices = narratorRepo.findAllOrdered()
                .stream()
                .map(PersonMapper::toSelectionDto)
                .collect(Collectors.toList());
        return ResponseFactory.options("Narradores disponibles", narratorChoices);
    }

    @Override
    public Response getPersonTable() {
        List<PersonTableDto> consolidatedRows = aggregateAllPersonTypes();
        consolidatedRows.sort(Comparator.comparingLong(PersonTableDto::getId));
        return ResponseFactory.rows("Tabla de personas", consolidatedRows);
    }

    private long parsePersonId(String idText) {
        try {
            return Long.parseLong(idText.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private Response validatePersonData(long id, PersonCreationRequest request) {
        if (!ValidationUtils.isValidId(id)) {
            return Response.error(MessageUtils.ID_PERSON_INVALID);
        }
        if (ValidationUtils.isBlank(request.getFirstName()) || 
            ValidationUtils.isBlank(request.getLastName())) {
            return Response.error(MessageUtils.NAME_REQUIRED);
        }
        if (isPersonIdAlreadyInUse(id)) {
            return Response.error(MessageUtils.ID_PERSON_EXISTS);
        }
        if (request.getRole() == null) {
            return Response.error(MessageUtils.ROLE_REQUIRED);
        }
        return Response.success("");
    }

    private Response persistPersonByRole(PersonCreationRequest request, long id) {
        switch (request.getRole()) {
            case AUTHOR -> {
                Author author = factory.createAuthor(id, request.getFirstName(), request.getLastName());
                authorRepo.save(author);
            }
            case MANAGER -> {
                Manager manager = factory.createManager(id, request.getFirstName(), request.getLastName());
                managerRepo.save(manager);
            }
            case NARRATOR -> {
                Narrator narrator = factory.createNarrator(id, request.getFirstName(), request.getLastName());
                narratorRepo.save(narrator);
            }
            default -> {
                return Response.error(MessageUtils.ROLE_NOT_SUPPORTED);
            }
        }
        
        changeNotifier.emit(DataChangeType.PERSONS);
        return Response.success(MessageUtils.PERSON_CREATED);
    }

    private List<PersonTableDto> aggregateAllPersonTypes() {
        List<PersonTableDto> allPersons = new ArrayList<>();
        
        authorRepo.findAllOrdered().forEach(author -> 
            allPersons.add(PersonMapper.toTableDto(author)));
        
        managerRepo.findAllOrdered().forEach(manager -> 
            allPersons.add(PersonMapper.toTableDto(manager)));
        
        narratorRepo.findAllOrdered().forEach(narrator -> 
            allPersons.add(PersonMapper.toTableDto(narrator)));
        
        return allPersons;
    }

    private boolean isPersonIdAlreadyInUse(long id) {
        return authorRepo.exists(id) || managerRepo.exists(id) || narratorRepo.exists(id);
    }
}
