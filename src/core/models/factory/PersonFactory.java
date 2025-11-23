package core.models.factory;

import core.controllers.dto.PersonRole;
import core.models.Author;
import core.models.Manager;
import core.models.Narrator;

/**
 * Instanciación de subclases de Persona.
 */
public class PersonFactory {

    public Author createAuthor(long id, String firstName, String lastName) {
        return new Author(id, firstName, lastName);
    }

    public Manager createManager(long id, String firstName, String lastName) {
        return new Manager(id, firstName, lastName);
    }

    public Narrator createNarrator(long id, String firstName, String lastName) {
        return new Narrator(id, firstName, lastName);
    }

    public Object createByRole(long id, String firstName, String lastName, PersonRole role) {
        if (role == null) {
            throw new IllegalStateException("El rol es obligatorio para crear una persona");
        }
        return switch (role) {
            case AUTHOR -> createAuthor(id, firstName, lastName);
            case MANAGER -> createManager(id, firstName, lastName);
            case NARRATOR -> createNarrator(id, firstName, lastName);
        };
    }
}
