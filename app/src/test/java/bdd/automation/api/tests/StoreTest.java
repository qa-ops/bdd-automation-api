package bdd.automation.api.tests;

import bdd.automation.api.support.api.PetApi;
import bdd.automation.api.support.api.StoreApi;
import bdd.automation.api.support.domain.Order;
import bdd.automation.api.support.domain.Pet;
import bdd.automation.api.support.domain.builders.OrderBuilder;
import io.restassured.response.Response;
import lombok.experimental.FieldNameConstants;
import org.junit.jupiter.api.*;

import java.net.SocketTimeoutException;

import static org.hamcrest.CoreMatchers.is;

public class StoreTest extends BaseTest {

    @Nested
    @DisplayName("User creates new order")
    class CreateNewOrder {

        PetApi petApi = new PetApi();
        StoreApi storeApi = new StoreApi();

        Pet expectedPet;

        @BeforeEach
        void setup() {
            Pet pet = Pet.builder()
                    .id(333)
                    .status("available")
                    .build();

            expectedPet = petApi.createPet(pet);
        }

        @Test
        @DisplayName("A user must be able to order a new pet")
        void userMustBeAbleToOrderAvailablePet() {
            Order order = new OrderBuilder()
                    .withId(888)
                    .withPetId(expectedPet.getId())
                    .build();

            Order expectedOrder = storeApi.createOrder(order);

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

        @AfterEach
        void deletePetsAvailableCreated() {
            petApi.deleteExtraPets("available");
        }
    }


}
