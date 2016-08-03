package by.grouk.callhandler.utils.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import by.grouk.callhandler.utils.exception.processing.ServiceProcessingException;

/**
 * Created by Alena_Grouk on 8/2/2016.
 */
public class ExceptionHandler implements ExceptionMapper<ServiceProcessingException> {
    public Response toResponse(ServiceProcessingException exception) {
        Response.Status status;

        status = Response.Status.INTERNAL_SERVER_ERROR;

        return Response.status(status).header("exception", exception.getLocalizedUserMessage())
                .entity(exception.getLocalizedUserMessage()).build();
    }
}
