package core.controllers.utils;

import core.controllers.dto.PersonTableDto;
import core.controllers.dto.SelectionOptionDto;
import core.models.Author;
import core.models.Manager;
import core.models.Narrator;
import core.models.Person;

/**
 * Mapper para convertir entidades Person a DTOs.
 */
public final class PersonMapper {

    private static final String NO_DATA_PLACEHOLDER = "-";
    private static final String AUTHOR_ROLE_LABEL = "Autor";
    private static final String MANAGER_ROLE_LABEL = "Gerente";
    private static final String NARRATOR_ROLE_LABEL = "Narrador";

    private PersonMapper() {
    }

    public static SelectionOptionDto toSelectionDto(Person person) {
        String identifier = String.valueOf(person.getId());
        String displayLabel = buildDisplayLabel(person.getId(), person.getFullname());
        return new SelectionOptionDto(identifier, displayLabel);
    }

    public static PersonTableDto toTableDto(Author author) {
        return new PersonTableDto(
                author.getId(),
                author.getFullname(),
                AUTHOR_ROLE_LABEL,
                NO_DATA_PLACEHOLDER,
                author.getBookQuantity()
        );
    }

    public static PersonTableDto toTableDto(Manager manager) {
        String publisherInfo = extractPublisherInfo(manager);
        return new PersonTableDto(
                manager.getId(),
                manager.getFullname(),
                MANAGER_ROLE_LABEL,
                publisherInfo,
                0
        );
    }

    public static PersonTableDto toTableDto(Narrator narrator) {
        return new PersonTableDto(
                narrator.getId(),
                narrator.getFullname(),
                NARRATOR_ROLE_LABEL,
                NO_DATA_PLACEHOLDER,
                narrator.getBookQuantity()
        );
    }

    private static String buildDisplayLabel(long id, String fullName) {
        return id + " - " + fullName;
    }

    private static String extractPublisherInfo(Manager manager) {
        if (manager.getPublisher() != null) {
            return manager.getPublisher().getName();
        }
        return NO_DATA_PLACEHOLDER;
    }
}

