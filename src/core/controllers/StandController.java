package core.controllers;

import core.controllers.dto.SelectionOptionDto;
import core.controllers.dto.StandCreationRequest;
import core.controllers.dto.StandTableDto;
import core.controllers.interfaces.IStandController;
import core.controllers.utils.MessageUtils;
import core.controllers.utils.Response;
import core.controllers.utils.ResponseFactory;
import core.controllers.utils.StandMapper;
import core.controllers.utils.ValidationUtils;
import core.models.Stand;
import core.models.factory.StandFactory;
import core.observer.DataChangeNotifier;
import core.observer.DataChangeType;
import core.repositories.interfaces.IRepository;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para todo lo relacionado con los stands.
 */
public class StandController implements IStandController {

    private final IRepository<Stand, Long> standRepository;
    private final DataChangeNotifier changeNotifier;
    private final StandFactory factory;

    public StandController(IRepository<Stand, Long> standRepository, StandFactory standFactory, 
                          DataChangeNotifier notifier) {
        this.standRepository = standRepository;
        this.factory = standFactory;
        this.changeNotifier = notifier;
    }

    @Override
    public Response createStand(StandCreationRequest request) {
        long standId = parseStandId(request.getId());
        if (standId < 0) {
            return Response.error(MessageUtils.ID_STAND_INTEGER);
        }

        double rentalPrice = parsePrice(request.getPrice());
        if (rentalPrice < 0) {
            return Response.error(MessageUtils.PRICE_STAND_VALID);
        }

        Response validationResult = validateStandData(standId, rentalPrice);
        if (!validationResult.isSuccess()) {
            return validationResult;
        }
        
        Stand newStand = factory.createStand(standId, rentalPrice);
        persistStand(newStand);
        
        return Response.success(MessageUtils.STAND_CREATED);
    }

    @Override
    public Response getStandOptions() {
        List<SelectionOptionDto> selectionList = standRepository.findAllOrdered()
                .stream()
                .map(StandMapper::toSelectionDto)
                .collect(Collectors.toList());
        return ResponseFactory.options("Listado de stands", selectionList);
    }

    @Override
    public Response getStandTable() {
        List<StandTableDto> tableRows = standRepository.findAllOrdered()
                .stream()
                .map(StandMapper::toTableDto)
                .collect(Collectors.toList());
        return ResponseFactory.rows("Listado de stands", tableRows);
    }

    private long parseStandId(String idText) {
        try {
            return Long.parseLong(idText.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private double parsePrice(String priceText) {
        try {
            return Double.parseDouble(priceText.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private Response validateStandData(long id, double price) {
        if (!ValidationUtils.isValidId(id)) {
            return Response.error(MessageUtils.ID_STAND_INVALID);
        }
        if (!ValidationUtils.isPositive(price)) {
            return Response.error(MessageUtils.PRICE_STAND_POSITIVE);
        }
        if (standRepository.exists(id)) {
            return Response.error(MessageUtils.ID_STAND_EXISTS);
        }
        return Response.success("");
    }

    private void persistStand(Stand stand) {
        standRepository.save(stand);
        changeNotifier.emit(DataChangeType.STANDS);
    }
}
