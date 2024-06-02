package com.scottapps.petshop.fish.service;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.scottapps.petshop.fish.model.FishCommand;
import com.scottapps.petshop.fish.model.FishRequestDto;
import io.quarkiverse.wiremock.devservice.ConnectWireMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@QuarkusTest
@ConnectWireMock
class FishOrchestrationServiceTest {

    static final String MOCK_MSG = "Hello from WireMock!";

    WireMock wiremock;

    @Inject
    FishOrchestrationService sut;

    @Test
    void testHelloEndpoint() {
        Assertions.assertNotNull(wiremock);
        wiremock.register(post(urlEqualTo("/mock/checkuperror"))
                .willReturn(aResponse().withStatus(500).withBody(MOCK_MSG)));
        sut.orchestrate(new FishCommand("TEST_ID", new FishRequestDto()));
    }

}