package by.grouk.callhandler.utils.exception.handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.jaxrs.validation.ValidationExceptionMapper;
import org.apache.cxf.validation.ResponseConstraintViolationException;

import by.grouk.callhandler.utils.localization.MessageLocalizator;

/**
 * Created by Alena_Grouk on 8/3/2016.
 */
@Provider
public class ValidationExceptionHandler extends ValidationExceptionMapper implements
        ExceptionMapper< ValidationException > {

    private static final Logger LOG = LogUtils.getL7dLogger(ValidationExceptionMapper.class);

    @Resource
    private MessageLocalizator localizator;

    public static final int VALIDATION_ERROR = 500;

    @Override
    public Response toResponse(ValidationException exception) {
        Response.Status errorStatus = Response.Status.INTERNAL_SERVER_ERROR;
        Object[] args = new Object[]{VALIDATION_ERROR};
        String header = localizator.localizeMessage("validation.exception.header", args);
        StringBuilder msg  = new StringBuilder();

        if (exception instanceof ConstraintViolationException) {

            final ConstraintViolationException constraint = (ConstraintViolationException) exception;

            for (final ConstraintViolation< ? > violation: constraint.getConstraintViolations()) {
                String message = localizator.localizeMessage(violation.getMessage());
                args = new Object[]{violation.getPropertyPath(), message};
                msg.append(localizator.localizeMessage("validation.exception.message", args));

                LOG.log(Level.WARNING,
                        violation.getRootBeanClass().getSimpleName()
                                + "." + violation.getPropertyPath()
                                + ": " + violation.getMessage());
            }

            if (!(constraint instanceof ResponseConstraintViolationException)) {
                errorStatus = Response.Status.BAD_REQUEST;
            }
        }
        Response response = JAXRSUtils.toResponseBuilder(errorStatus)
                .header("exception", header).entity(msg.toString()).build();
        return response;
    }
}
