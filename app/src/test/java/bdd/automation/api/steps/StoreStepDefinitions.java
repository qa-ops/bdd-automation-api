package bdd.automation.api.steps;

import bdd.automation.api.support.domain.Store;
import bdd.automation.api.support.domain.builders.StoreBuilder;
import io.cucumber.java.en.Given;

public class StoreStepDefinitions {
    @Given("something..")
    public void something() {
        Store store1 = new StoreBuilder().build();

        Store store2 = new StoreBuilder()
                .withId(9)
                .withPetId(99)
                .withQuantity(100)
                .withStatus("complete")
                .withShipDate("11/01/2021")
                .build();

        Store store3 = new StoreBuilder()
                .withPetId(88)
                .withQuantity(50)
                .withStatus("incomplete")
                .build();

        Store store4 = new StoreBuilder().build();

        System.out.println("asdasd");
    }
}
