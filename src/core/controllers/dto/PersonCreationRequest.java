package core.controllers.dto;

public class PersonCreationRequest {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final PersonRole role;

    public PersonCreationRequest(String id, String firstName, String lastName, PersonRole role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonRole getRole() {
        return role;
    }
}
