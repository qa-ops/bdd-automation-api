package bdd.automation.api.support.domain.builders;

import bdd.automation.api.support.domain.Store;

public class StoreBuilder {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public StoreBuilder() {
        reset();
    }

    public StoreBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public StoreBuilder withPetId(int petId) {
        this.petId = petId;
        return this;
    }

    public StoreBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public StoreBuilder withShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    public StoreBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public StoreBuilder withComplete(Boolean complete) {
        this.complete = complete;
        return this;
    }

    public Store build() {
        return new Store(
            id,
            petId,
            quantity,
            shipDate,
            status,
            complete
        );
    }

    public void reset() {
        id = 5;
        petId = 22;
        quantity = 10;
        shipDate = "20/02/2021";
        status = "approved";
        complete = true;
    }
}
