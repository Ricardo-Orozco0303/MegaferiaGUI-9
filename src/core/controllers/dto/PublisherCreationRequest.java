package core.controllers.dto;

public class PublisherCreationRequest {

    private final String nit;
    private final String name;
    private final String address;
    private final String managerId;

    public PublisherCreationRequest(String nit, String name, String address, String managerId) {
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.managerId = managerId;
    }

    public String getNit() {
        return nit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getManagerId() {
        return managerId;
    }
}
