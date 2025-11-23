package core.controllers;

import core.controllers.dto.StandPurchaseRequest;
import core.controllers.interfaces.IPurchaseController;
import core.controllers.utils.MessageUtils;
import core.controllers.utils.Response;
import core.controllers.utils.ValidationUtils;
import core.models.Publisher;
import core.models.Stand;
import core.models.factory.PublisherAssignmentFactory;
import core.repositories.interfaces.IPublisherRepository;
import core.repositories.interfaces.IRepository;
import core.observer.DataChangeNotifier;
import core.observer.DataChangeType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Controlador para la compra de stands por editoriales.
 */
public class PurchaseController implements IPurchaseController {

    private final IRepository<Stand, Long> standRepo;
    private final IPublisherRepository publisherRepo;
    private final PublisherAssignmentFactory linkFactory;
    private final DataChangeNotifier changeNotifier;

    public PurchaseController(IRepository<Stand, Long> standRepository,
            IPublisherRepository publisherRepository,
            PublisherAssignmentFactory assignmentFactory,
            DataChangeNotifier notifier) {
        this.standRepo = standRepository;
        this.publisherRepo = publisherRepository;
        this.linkFactory = assignmentFactory;
        this.changeNotifier = notifier;
    }

    @Override
    public Response purchaseStands(StandPurchaseRequest request) {
        Response initialValidation = validatePurchaseRequest(request);
        if (!initialValidation.isSuccess()) {
            return initialValidation;
        }
        
        List<Long> standIdentifiers = parseStandIds(request.getStandIds());
        if (standIdentifiers == null) {
            return Response.error(MessageUtils.STAND_ID_INVALID);
        }

        Response uniquenessCheck = verifyNoDuplicates(standIdentifiers, request.getPublisherNits());
        if (!uniquenessCheck.isSuccess()) {
            return uniquenessCheck;
        }

        List<Stand> selectedStands = retrieveStands(standIdentifiers);
        if (selectedStands == null) {
            return Response.error(MessageUtils.STAND_NOT_FOUND_ID);
        }

        List<Publisher> buyingPublishers = retrievePublishers(request.getPublisherNits());
        if (buyingPublishers == null) {
            return Response.error(MessageUtils.PUBLISHER_NOT_FOUND_NIT);
        }

        establishPurchaseLinks(selectedStands, buyingPublishers);
        changeNotifier.emit(DataChangeType.PURCHASES);
        
        return Response.success(MessageUtils.PURCHASE_SUCCESS);
    }

    private Response validatePurchaseRequest(StandPurchaseRequest request) {
        if (request.getStandIds() == null || request.getStandIds().isEmpty()) {
            return Response.error(MessageUtils.STAND_REQUIRED);
        }
        if (request.getPublisherNits() == null || request.getPublisherNits().isEmpty()) {
            return Response.error(MessageUtils.PUBLISHER_REQUIRED);
        }
        return Response.success("");
    }

    private List<Long> parseStandIds(List<String> idStrings) {
        try {
            List<Long> parsedIds = new ArrayList<>();
            for (String idText : idStrings) {
                parsedIds.add(Long.parseLong(idText.trim()));
            }
            return parsedIds;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Response verifyNoDuplicates(List<Long> standIds, List<String> nits) {
        if (!areAllUnique(standIds)) {
            return Response.error(MessageUtils.STAND_DUPLICATE);
        }
        if (!areAllUnique(nits)) {
            return Response.error(MessageUtils.PUBLISHER_DUPLICATE);
        }
        return Response.success("");
    }

    private List<Stand> retrieveStands(List<Long> standIds) {
        List<Stand> foundStands = new ArrayList<>();
        for (Long standId : standIds) {
            if (!ValidationUtils.isValidId(standId)) {
                return null;
            }
            Stand stand = standRepo.findById(standId).orElse(null);
            if (stand == null) {
                return null;
            }
            foundStands.add(stand);
        }
        return foundStands;
    }

    private List<Publisher> retrievePublishers(List<String> nits) {
        List<Publisher> foundPublishers = new ArrayList<>();
        for (String nit : nits) {
            if (!ValidationUtils.isValidNit(nit)) {
                return null;
            }
            Publisher publisher = publisherRepo.findByNit(nit).orElse(null);
            if (publisher == null) {
                return null;
            }
            foundPublishers.add(publisher);
        }
        return foundPublishers;
    }

    private void establishPurchaseLinks(List<Stand> stands, List<Publisher> publishers) {
        for (Stand stand : stands) {
            for (Publisher publisher : publishers) {
                linkFactory.link(stand, publisher);
            }
        }
    }

    private <T> boolean areAllUnique(List<T> items) {
        Set<T> uniqueItems = new HashSet<>(items);
        return uniqueItems.size() == items.size();
    }
}
