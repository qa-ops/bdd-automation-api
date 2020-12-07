package bdd.automation.api.steps;

import bdd.automation.api.support.api.UserApi;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class Config {

    private final UserApi userApi;

    public Config() {
        userApi = new UserApi();
    }

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.baseURI = "http://localhost:12345";
        RestAssured.basePath = "/api";

        RestAssured.requestSpecification = new RequestSpecBuilder().
            addHeader("Authorization", getToken()).
            setContentType(ContentType.JSON).
            build();
    }

    private String getToken() {
        return "grant access";
    }

    @Before(value = "@primeiro", order = 3)
    public void doSomething() {
        System.out.println("before primeiro");
    }

    @Before(value = "@segundo", order = 3)
    public void doAnotherThing() {
        System.out.println("before segundo");
    }

    @Before(value = "@terceiro", order = 1)
    public void doSomethingInteresting() {
        System.out.println("before terceiro");
    }


    @After(value = "@primeiro", order = 3)
    public void doSomethingAfter() {
        System.out.println("after primeiro");
    }

    @After(value = "@segundo", order = 3)
    public void doAnotherThingAfter() {
        System.out.println("after segundo");
    }

    @After(value = "@terceiro", order = 2)
    public void doSomethingInterestingAfter() {
        System.out.println("after terceiro");
    }

    @After("@deleteAllUsers")
    public void deleteAllUsers() {
        userApi.deleteAllUsers();
    }

}
