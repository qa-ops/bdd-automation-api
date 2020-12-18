package bdd.automation.api.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class Config {

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.baseURI = "http://localhost:12345";
        RestAssured.basePath = "/api";

        RestAssured.requestSpecification = new RequestSpecBuilder().
            addHeader("Authorization", getToken()).
            setContentType(ContentType.JSON).
            build();

        RestAssured.responseSpecification = new ResponseSpecBuilder().
            expectContentType(ContentType.JSON).
            build();
    }

    private String getToken() {
        return "grant access";
    }

    @Before
    public void doSomething() {
        System.out.println("hook before");
    }

    @Before(value = "@first", order = 1)
    public void doFirst() {
        System.out.println("before first");
    }

    @Before(value = "@second", order = 2)
    public void doSecond() {
        System.out.println("before second");
    }

    @Before(value = "@third", order = 3)
    public void doThird() {
        System.out.println("before third");
    }


    @After(value = "@first", order = 3)
    public void doLast() {
        System.out.println("after first");
    }

    @After(value = "@second", order = 2)
    public void doLast2() {
        System.out.println("after second");
    }

    @After(value = "@third", order = 1)
    public void doLast3() {
        System.out.println("after third");
    }
}
