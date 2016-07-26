package by.grouk.callhandler.rest;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import by.grouk.callhandler.model.PhoneCall;

/**
 * Created by Alena_Grouk on 7/24/2016.
 */
@Path("/phoneCall")
public interface PhoneCallRestService {

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    void addCall(@Valid PhoneCall phoneCall);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response createCall(@PathParam("id") @Pattern(regexp = "[0-9]+", message = "The id must be a valid number")
            String id);
}
