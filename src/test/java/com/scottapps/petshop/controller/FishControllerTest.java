package com.scottapps.petshop.controller;

import com.scottapps.petshop.fish.model.FishRequestDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@QuarkusTest
public class FishControllerTest {
    @Test
    public void testPost() {
        given()
                .body(new FishRequestDto("FishControllerTest"))
                .header("Content-Type", "application/json")
                .when()
                .post("/fish")
                .then()
                .statusCode(200);
//                .and()
//                .body("request.message", is("Works!"));
    }
}
