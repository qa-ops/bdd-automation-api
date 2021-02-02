package bdd.automation.api.tests;

import bdd.automation.api.support.api.UserApi;
import bdd.automation.api.support.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("User feature tests")
public class UserTest extends BaseTest {

    UserApi userApi = new UserApi();
    User expectedUser;

    @Test
    @DisplayName("A user must be able to register into the system")
    void mustBeAbleToCreateNewUser() {
        expectedUser = User.builder().build();

        userApi.createUser(expectedUser);

        String actualUsername = userApi.getUsername(expectedUser);

        assertThat(actualUsername, is(expectedUser.getUsername()));
    }

    @AfterEach
    void deleteNewUser() {
        userApi.deleteUser(expectedUser);
    }

}
