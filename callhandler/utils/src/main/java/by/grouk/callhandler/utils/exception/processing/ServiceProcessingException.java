package by.grouk.callhandler.utils.exception.processing;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.utils.exception.ExceptionConstants;

/**
 * Created by Alena_Grouk on 8/1/2016.
 */
@Component
@Scope(value="prototype", proxyMode = ScopedProxyMode.NO)
public class ServiceProcessingException extends ProcessingException {

    public ServiceProcessingException() {}

    public ServiceProcessingException(int anErrorCode, String errorMsg) {
        super(anErrorCode, errorMsg);
    }

    public ServiceProcessingException(int anErrorCode, String errorMsg, Throwable cause) {
        super(anErrorCode, errorMsg, cause);
    }

    @Override
    public String generateUserMessage(int anErrorCode, String errorMsg) {
        StringBuilder msg;
        if (anErrorCode > 0) {
            msg = new StringBuilder(ExceptionConstants.ERROR_CODE_KEY_SUFFIX)
                    .append(anErrorCode);
        } else {
            msg = new StringBuilder(ExceptionConstants.DEFAULT_ERROR_CODE_TEXT);
        }
        msg.append(ExceptionConstants.ERROR_CODE_SEPARATOR)
                .append(errorMsg);
        return msg.toString();
    }
}
