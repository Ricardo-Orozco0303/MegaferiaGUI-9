package core.controllers.dto;

public class StandCreationRequest {

    private final String id;
    private final String price;

    public StandCreationRequest(String id, String price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }
}
