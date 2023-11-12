package com.scottapps.petshop.domain.fish.controller;

import com.scottapps.petshop.domain.fish.model.FishRequestDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

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
    }
}
