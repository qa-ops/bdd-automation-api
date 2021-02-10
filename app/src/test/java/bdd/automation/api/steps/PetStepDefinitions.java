package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import bdd.automation.api.support.domain.Pet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

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
    @Dado("que eu possua animais available")
    public void thatIHavePetsAvailable() {}

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
}
