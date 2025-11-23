package core.controllers.utils;

import core.controllers.dto.PublisherTableDto;
import core.controllers.dto.SelectionOptionDto;
import core.models.Publisher;

/**
 * Mapper para convertir entidades Publisher a DTOs.
 */
public final class PublisherMapper {

    private PublisherMapper() {
        throw new AssertionError("Mapper class should not be instantiated");
    }

    public static SelectionOptionDto toSelectionDto(Publisher publisher) {
        String displayText = formatPublisherDisplay(publisher.getName(), publisher.getNit());
        return new SelectionOptionDto(publisher.getNit(), displayText);
    }

    public static PublisherTableDto toTableDto(Publisher publisher) {
        return new PublisherTableDto(
                publisher.getNit(),
                publisher.getName(),
                publisher.getAddress(),
                publisher.getManager().getFullname(),
                publisher.getStandQuantity()
        );
    }

    private static String formatPublisherDisplay(String name, String nit) {
        return name + " (" + nit + ")";
    }
}

