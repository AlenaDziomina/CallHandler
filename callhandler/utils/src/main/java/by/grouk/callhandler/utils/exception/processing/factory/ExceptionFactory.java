package by.grouk.callhandler.utils.exception.processing.factory;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.utils.exception.processing.ServiceProcessingException;

/**
 * Created by Alena_Grouk on 8/2/2016.
 */
@Component
public class ExceptionFactory {

    @Resource(name = "error_strings")
    private MessageSource messageSource;

    @Value("#{config['language']}")
    private String language;

    public static final int INTERNAL_ERROR = 400;
    public static final int INVALID_NULL_OBJECT = 401;

    @Lookup
    public ServiceProcessingException getServiceProcessingException(int errorCode, String errorMsg){
        return new ServiceProcessingException(errorCode, errorMsg);
    }

    @Lookup
    public ServiceProcessingException getServiceProcessingException(int errorCode, String errorMsg, Throwable e){
        return new ServiceProcessingException(errorCode, errorMsg, e);
    }

    public ServiceProcessingException createInternalException(Throwable e) {
        String msg = getMessage("common.internal_error", null);
        return getServiceProcessingException(INTERNAL_ERROR, msg, e);
    }

    public ServiceProcessingException createInvalidNullObjectException(String className) {
        Object[] args = new Object[]{className};
        String msg = getMessage("common.invalid_null_object", args);
        ServiceProcessingException spe = getServiceProcessingException(INVALID_NULL_OBJECT, msg);
        return spe;
    }

    public ServiceProcessingException createInvalidNullObjectException() {
        Object[] args = new Object[]{"unknown"};
        String msg = getMessage("common.invalid_null_object", args);
        ServiceProcessingException spe = getServiceProcessingException(INVALID_NULL_OBJECT, msg);
        return spe;
    }

    protected Locale getLocale() {
        return new Locale(language);
    }

    protected String getMessage(String msgCode, Object[] args) {
        return messageSource.getMessage(msgCode, args, getLocale());
    }
}
