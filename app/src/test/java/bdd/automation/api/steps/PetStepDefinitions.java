package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import bdd.automation.api.support.domain.Pet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.*;
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
    private Response actualPetsResponse;

    public PetStepDefinitions() {
        petApi = new PetApi();
    }

    @Given("that I have pets {word}")
    @Dado("que eu possua animais {word}")
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
    @E("eu recebo uma outra lista de animais {word}")
    public void iReceiveAnotherListOfPetsAvailable(String status) {
        Response actualPetsResponse = petApi.getPetsResponseByStatus(status);

        actualPets = actualPetsResponse.body().jsonPath().getList("", Pet.class);

        actualPetsResponse.
            then().
                statusCode(HttpStatus.SC_OK).
                body(
                    "size()", is(50),
                    "findAll { it.status == '"+status+"' }.size()", is(actualPets.size())
                );

    }

    @Então("eu recebo a lista com {} animal/animais")
    @Then("I receive a list of {} pet(s)")
    public void iReceiveAListOfPets(int petsQuantity) {
        assertThat(actualPets.size(), is(petsQuantity));
    }

    @Dado("que eu não possua animais {word}")
    @Given("that I don't have pets {word}")
    public void thatIdontHavePets(String status) {
        petApi.deletePetsByStatus(status);
    }

    @When("I do a search for all pets {word}")
    @Quando("pesquiso por todos os animais {word}")
    public void iDoASearchForAllPetsAvailable(String status) {
        actualPetsResponse = petApi.getPetsResponseByStatus(status);
    }

    @Then("I receive a list of {int} pets {word}")
    @Entao("recebo a lista com {int} animais {word}")
    public void iReceiveAListOfPetsAvailable(int petsQuantity, String status) {
        actualPetsResponse.
            then().
                statusCode(HttpStatus.SC_OK).
                body(
                    "size()", is(petsQuantity),
                    "findAll { it.status == '" + status + "' }.size()", is(petsQuantity)
                );

    }

    @And("{int} pets has the name {word}")
    @E("{int} animais possuem o nome {word}")
    public void petsHasTheNameLion(int petsQuantity, String petName) {
        actualPetsResponse.
            then().
                body(
                    "findAll { it.name.contains('"+petName+"') }.size()", is(petsQuantity)
                );
    }
}
