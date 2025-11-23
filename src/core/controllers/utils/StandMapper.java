package core.controllers.utils;

import core.controllers.dto.SelectionOptionDto;
import core.controllers.dto.StandTableDto;
import core.models.Stand;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entidades Stand a DTOs.
 */
public final class StandMapper {

    private static final String PUBLISHER_SEPARATOR = ", ";
    private static final String NO_PUBLISHERS = "";

    private StandMapper() {
        throw new AssertionError("Mapper class should not be instantiated");
    }

    public static StandTableDto toTableDto(Stand stand) {
        String publisherNames = buildPublisherNamesList(stand);
        boolean hasAssignedPublishers = stand.getPublisherQuantity() > 0;
        
        return new StandTableDto(
                stand.getId(),
                stand.getPrice(),
                hasAssignedPublishers,
                publisherNames
        );
    }

    public static SelectionOptionDto toSelectionDto(Stand stand) {
        String standIdAsString = String.valueOf(stand.getId());
        return new SelectionOptionDto(standIdAsString, standIdAsString);
    }

    private static String buildPublisherNamesList(Stand stand) {
        if (stand.getPublisherQuantity() == 0) {
            return NO_PUBLISHERS;
        }
        
        List<String> publisherNames = stand.getPublishers()
                .stream()
                .map(publisher -> publisher.getName())
                .collect(Collectors.toList());
        
        return String.join(PUBLISHER_SEPARATOR, publisherNames);
    }
}

