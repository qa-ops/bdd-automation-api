package bdd.automation.api.support.api;

import bdd.automation.api.support.domain.Order;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class StoreApi {

    private static final String CREATE_ORDER_ENDPOINT = "/v3/store/order";
    private static final String GET_ORDER_ENDPOINT = "/v3/store/order/{id}";

    public Order createOrder(Order order) {
        return given().
                body(order).
            when().
                post(CREATE_ORDER_ENDPOINT).
            then().
                statusCode(HttpStatus.SC_OK).
                extract().body().as(Order.class);
    }

    public Response getOrder(int id) {
        return given().
                pathParam("id",id).
            when().
                get(GET_ORDER_ENDPOINT);
    }
}
