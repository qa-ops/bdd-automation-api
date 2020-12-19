package bdd.automation.api.steps;

import bdd.automation.api.support.domain.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;

public class PetStepDefinitions {
    @Given("that I have pets available")
    public void thatIHavePetsAvailable() throws JsonProcessingException {
        Pet pet = Pet.builder().build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pet);
        System.out.println(json);
    }
}
