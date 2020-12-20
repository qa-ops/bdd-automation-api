package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import bdd.automation.api.support.domain.Pet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class PetStepDefinitions {

    private PetApi petApi;
    private List<Pet> actualPets;

    public PetStepDefinitions() {
        petApi = new PetApi();
    }

    @Given("that I have pets available")
    @Dado("que eu possua animais {}")
    public void thatIHavePetsAvailable(String status) {}

    @When("I search for all pets {word}")
    @Quando("eu pesquiso por todos os animais {word}")
    public void iSearchForAllPetsAvailable(String status) {
        actualPets = petApi.getPetsByStatus(status);
    }

    @Then("I receive a list of pets available")
    @Entao("eu recebo a lista de animais available")
    public void iReceiveAListOfPetsAvailable() {
        assertThat(actualPets, is(not(empty())));
    }

    @And("I receive another list of pets {word}")
    public void iReceiveAnotherListOfPetsAvailable(String status) {
        Response actualPetsAvailableResponse = petApi.getPetsResponseByStatus(status);

        actualPets = actualPetsAvailableResponse.body().jsonPath().getList("", Pet.class);

        actualPetsAvailableResponse.
            then().
                statusCode(HttpStatus.SC_OK).
                body(
                    "size()", is(actualPets.size()),
                    "findAll { it.status == 'available' }.size()", is(actualPets.size())
                );

    }

    @Então("eu recebo a lista com {int} animal/animais")
    public void euReceboAListaComAnimais(int petsQuantity) {
        assertThat(actualPets.size(), is(petsQuantity));
    }

    @Dado("que eu não possua animais {word}")
    public void queEuNãoPossuaAnimaisSold(String status) {
        petApi.deletePetsByStatus(status);
    }
}
