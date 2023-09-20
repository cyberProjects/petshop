package com.scottapps.petshop.domain.fish.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scottapps.petshop.domain.fish.mapper.FishRequestMapperService;
import com.scottapps.petshop.externservice.checkup.service.CheckupService;
import com.scottapps.petshop.externservice.clean.service.CleanService;
import com.scottapps.petshop.externservice.feed.service.FeedService;
import com.scottapps.petshop.model.domain.fish.FishContext;
import com.scottapps.petshop.model.domain.fish.FishResponse;
import com.scottapps.petshop.model.externservice.checkup.CheckupRequest;
import com.scottapps.petshop.model.externservice.checkup.CheckupServiceResponse;
import com.scottapps.petshop.response.FishResponder;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FishService {
    @Inject
    Logger log;

    @Inject
    @RequestScoped
    FishContext fishContext;

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
//            var feedResponse = feedService.apply(mapper.toFeedRequest(request));
//            var cleanResponse = cleanService.apply(mapper.toCleanRequest(request));
            var checkupServiceResponse = callCheckupService(request);
            fishContext.setResponse(new FishResponse());
            fishContext.setDataStore("Fish Stored");
            return Response.ok().entity(checkupServiceResponse).build();
        } catch (RuntimeException e) {
            log.error("Exception thrown");
            log.error(e.getLocalizedMessage());
            return Response.serverError().build();
        }
    }

    private CheckupServiceResponse callCheckupService(FishContext request) {
        var checkupReqOptional = mapper.toCheckupRequest(request);
        return checkupService.apply(checkupReqOptional.get());
    }
}
