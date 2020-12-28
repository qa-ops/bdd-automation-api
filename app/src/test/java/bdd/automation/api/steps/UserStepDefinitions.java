package bdd.automation.api.steps;

import bdd.automation.api.support.domain.User;
import io.cucumber.docstring.DocString;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class UserStepDefinitions {

    private static final String CREATE_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{name}";

    private Map<String, String> expectedUser = new HashMap<>();

    private User user;

    @When("I do a POST to {word} with the following values:")
    @Quando("eu faço um POST para {word} com os seguintes valores:")
    public void iDoAPOSTToVUserWithTheFollowingValues(String endpoint, Map<String, String> user) {
        expectedUser = user;

        given().
            body(user).
        when().
            post(endpoint).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    @Then("I receive the created user when I do a GET to {word}")
    @Então("quando faço um GET para {word}, o usuário criado é retornado")
    public void iReceiveTheCreatedUserWhenIDoAGETToVUserRafael(String endpoint) {
        when().
            get(endpoint).
        then().
            statusCode(HttpStatus.SC_OK).
            body("username", is(expectedUser.get("username")));
    }

    @When("I do a POST to {word} with the docstring:")
    @Quando("eu faço um POST para {word} com a seguinte docString:")
    public void iDoAPOSTToVUserWithTheDoctstring(String endpoint, DocString docString) {
        expectedUser.put("username", "theUser");

        given().
            body(docString.getContent()).
        when().
            post(endpoint).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    @Quando("crio um usuário")
    @When("I create a user")
    public void iCreateAUser() {
        user = User.builder().build();

        given().
            body(user).
        when().
            post(CREATE_USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK);

    }

    @Então("o usuário é salvo no sistema")
    @Then("the created user was stored")
    public void theCreatedUserWasStored() {
        given().
            pathParam("name", user.getUsername()).
        when().
            get(USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK).
            body("username", is(user.getUsername()));
    }
}
