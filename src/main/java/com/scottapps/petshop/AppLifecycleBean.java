package com.scottapps.petshop;

import com.scottapps.petshop.fish.service.FishOrchestrationService;
import com.scottapps.petshop.fish.model.FishRequestDto;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class AppLifecycleBean {
    @Inject
    private FishOrchestrationService service;

    void onStart(@Observes StartupEvent ev) {
        service.orchestrate(new FishRequestDto());
    }

    void onStop(@Observes ShutdownEvent ev) {}
}
