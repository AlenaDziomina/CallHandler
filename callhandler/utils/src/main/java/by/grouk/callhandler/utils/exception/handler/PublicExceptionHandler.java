package by.grouk.callhandler.utils.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import by.grouk.callhandler.utils.exception.impl.PublicException;

/**
 * Created by Alena_Grouk on 8/3/2016.
 */
public class PublicExceptionHandler implements ExceptionMapper<PublicException> {

    public Response toResponse(PublicException exception) {
        Response.Status status;

        status = Response.Status.INTERNAL_SERVER_ERROR;

        return Response.status(status).header("exception", exception.getMessage())
                .entity(exception.getMessage()).build();
    }

}
