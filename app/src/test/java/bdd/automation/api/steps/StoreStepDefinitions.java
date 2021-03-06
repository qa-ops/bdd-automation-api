package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import bdd.automation.api.support.api.StoreApi;
import bdd.automation.api.support.domain.Order;
import bdd.automation.api.support.domain.Pet;
import bdd.automation.api.support.domain.builders.OrderBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.is;

public class StoreStepDefinitions {

    PetApi petApi;
    StoreApi storeApi;

    Pet expectedPet;
    Order expectedOrder;

    public StoreStepDefinitions() {
        petApi = new PetApi();
        storeApi = new StoreApi();
    }

    @Given("I have a pet {word}")
    @Dado("que eu possua animal {word}")
    public void iHaveAPetAvailable(String status) {
        Pet pet = Pet.builder()
                .id(333)
                .status(status)
                .build();

        expectedPet = petApi.createPet(pet);
    }

    @When("I order that pet")
    @Quando("faço o pedido desse animal")
    public void iOrderThatPet() {
        Order order = new OrderBuilder()
                .withId(888)
                .withPetId(expectedPet.getId())
                .build();

        expectedOrder = storeApi.createOrder(order);
    }


    @Then("the order is approved")
    @Entao("o pedido é aprovado")
    public void theOrderIsApproved() {
        Response actualOrderResponse = storeApi.getOrder(expectedOrder.getId());

        actualOrderResponse.
                then().
                    body(
                            "id",is(expectedOrder.getId()),
                            "petId", is(expectedPet.getId()),
                            "quantity", is(expectedOrder.getQuantity()),
                            "status", is("approved")
                    );

    }
}
