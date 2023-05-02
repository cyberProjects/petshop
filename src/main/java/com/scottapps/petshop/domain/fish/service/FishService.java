package com.scottapps.petshop.domain.fish.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scottapps.petshop.domain.fish.mapper.FishRequestMapperService;
import com.scottapps.petshop.externservice.checkup.service.CheckupService;
import com.scottapps.petshop.externservice.clean.service.CleanService;
import com.scottapps.petshop.externservice.feed.service.FeedService;
import com.scottapps.petshop.model.domain.fish.FishContext;
import com.scottapps.petshop.response.FishResponder;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FishService {
    @Inject
    Logger log;

    @Inject
    FeedService feedService;

    @Inject
    CleanService cleanService;

    @Inject
    CheckupService checkupService;

    @Inject
    FishRequestMapperService mapper;

    @Inject
    FishResponder fishResponder;

    @Inject
    ObjectMapper objectMapper;

    /**
     * Replace try/catch with @Fallback
     * @param request
     * @return
     */
    public Response apply(FishContext request) {
        try {
            log.info("FishService");
            var feedResponse = feedService.apply(mapper.toFeedRequest(request));
            var cleanResponse = cleanService.apply(mapper.toCleanRequest(request));
            var checkupResponse = checkupService.apply(mapper.toCheckupRequest(request));
            log.infov("CheckupResponse: {0}", objectMapper.writeValueAsString(checkupResponse));
            return Response.ok().entity(request).build();
        } catch (RuntimeException | JsonProcessingException e) {
            log.error("Exception thrown");
            log.error(e.getLocalizedMessage());
            return Response.serverError().build();
        }
    }
}
