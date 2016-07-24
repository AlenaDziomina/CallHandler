package by.grouk.callhandler.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
    void addCall(PhoneCall phoneCall);

    @GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    Response createCall();
}
