package com.scottapps.petshop.domain.fish;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FishServiceTemplate1 {
    @Inject
    Logger log;

    @Inject
    private FishRequestMapperService mappers;

    @Inject
    FishCheckupService checkup;

    /**
     * Add @Fallback
     * @param dto
     * @return
     */
    public Response apply(FishRequestDto dto) {
        var fishContext = new FishContext();
        var violations = validateIn(dto);
        var fishRequest = map(dto, fishContext);
        fishContext.setRequest(fishRequest);
        var result = process(fishContext);
        log.info(fishContext);
        return Response.ok().entity(result).build();
    }

    private List<ConstraintViolation> validateIn(FishRequestDto dto) {
        return new ArrayList<>();
    }

    private FishRequest map(FishRequestDto dto, FishContext context) {
        var fishRequestOptional = mappers.toFishRequest(dto);
        if (fishRequestOptional.isEmpty()) {
            log.error("Could not properly map to FishRequest!");
            throw new IllegalStateException("Must have a valid FishRequest!");
        } else {
            var fishRequest = fishRequestOptional.get();
            log.info("Successfully mapped FishRequest!");
            return fishRequest;
        }
    }

    private void persist() {
    }

    private FishResponse process(FishContext context) {
        var checkupServiceResponse = checkup.callCheckupService(context);
        context.getDataStore().getCheckupServiceResponseList().add(checkupServiceResponse);
        return new FishResponse();
    }

    private List<ConstraintViolation> validateOut() {
        return new ArrayList<>();
    }

    private void upload() {
    }

    private void respond() {
    }

    private void cleanup() {
    }

}
