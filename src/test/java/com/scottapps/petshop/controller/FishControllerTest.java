package com.scottapps.petshop.controller;

import com.scottapps.petshop.fish.model.FishRequestDto;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusIntegrationTest
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
    }
}
