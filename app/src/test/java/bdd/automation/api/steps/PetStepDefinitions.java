package bdd.automation.api.steps;

import bdd.automation.api.support.domain.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.pt.Dado;

public class PetStepDefinitions {

    @Dado("que eu possua pets available")
    @Given("that I have pets available")
    public void thatIHavePetsAvailable() throws JsonProcessingException {
        Pet pet = Pet.builder().build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pet);
        System.out.println(json);
    }
}
