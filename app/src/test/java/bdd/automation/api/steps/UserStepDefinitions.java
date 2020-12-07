package bdd.automation.api.steps;

import bdd.automation.api.support.api.UserApi;
import bdd.automation.api.support.domain.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserStepDefinitions {

    private final UserApi userApi;

    public UserStepDefinitions() {
         userApi = new UserApi();
    }

    private User expectedUser;

    @Quando("crio um usuário")
    @When("I create a user")
    public void iCreateAUser() {
        expectedUser = User.builder().build();

        userApi.createUser(expectedUser);
    }

    @Então("o usuário é salvo no sistema")
    @Then("the created user was stored")
    public void theCreatedUserWasStored() {
        String actualUsername = userApi.getUsername(expectedUser);

        assertThat(actualUsername, is(expectedUser.getUsername()));
    }
}
