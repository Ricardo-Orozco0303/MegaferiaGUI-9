package core.controllers.dto;

import java.util.List;

public class StandPurchaseRequest {

    private final List<String> standIds;
    private final List<String> publisherNits;

    public StandPurchaseRequest(List<String> standIds, List<String> publisherNits) {
        this.standIds = standIds;
        this.publisherNits = publisherNits;
    }

    public List<String> getStandIds() {
        return standIds;
    }

    public List<String> getPublisherNits() {
        return publisherNits;
    }
}
