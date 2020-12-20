package bdd.automation.api.support.api;

import bdd.automation.api.support.domain.Pet;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.*;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "v3/pet/findByStatus?status={status}";

//    public List<Pet> getPetsByStatus(String status) {
//        return given().
//            pathParam("status", status).
//        when().
//            get(FIND_PETS_BY_STATUS_ENDPOINT).
//        then().
//            extract().body().jsonPath().getList("", Pet.class);
//    }

    public List<Pet> getPetsByStatus(String status) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.pathParam("status", status);
        Response response = httpRequest.get(FIND_PETS_BY_STATUS_ENDPOINT);
        return response.body().jsonPath().getList("", Pet.class);
    }

}
