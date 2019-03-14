package org.dropwizard.rest.resources;

import com.codahale.metrics.annotation.Timed;
import org.dropwizard.rest.api.Representation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/v1/resource")
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {

    private final String message;
    private final String firstParameter;
    private final String secondParameter;

    public DemoResource(String message, String firstParameter, String secondParameter) {
        this.message = message;
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    @GET
    @Timed
    public Representation getMessage(@QueryParam("first") Optional<String> first, @QueryParam("second") Optional<String> second) {
        final String value = String.format(message, first.orElse(firstParameter), second.orElse(secondParameter));
        return new Representation(value);
    }

}
