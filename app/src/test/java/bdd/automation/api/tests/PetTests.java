package bdd.automation.api.tests;

import bdd.automation.api.support.api.PetApi;
import bdd.automation.api.support.domain.Pet;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.Matchers.is;

public class PetTests extends BaseTest {

    @Nested
    @DisplayName("List pets")
    class ListPets {
        PetApi petApi = new PetApi();

        @ParameterizedTest
        @CsvSource({
                "available, 7",
                "pending,   2",
                "sold,      0"
        })
        void listAllPetsExceptOnSoldState(String status, int quantity) {
            petApi.deletePetsByStatus("sold");

            Response actualPetsResponse = petApi.getPetsResponseByStatus(status);

            actualPetsResponse.
                then().
                    statusCode(HttpStatus.SC_OK).
                    body(
                        "size()", is(quantity),
                        "findAll { it.status == '"+status+"' }.size()", is(quantity)
                    );
        }

    }

}
