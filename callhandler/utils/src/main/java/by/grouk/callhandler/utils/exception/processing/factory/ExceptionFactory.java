package by.grouk.callhandler.utils.exception.processing.factory;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.utils.exception.processing.ServiceProcessingException;
import by.grouk.callhandler.utils.localization.MessageLocalizator;

/**
 * Created by Alena_Grouk on 8/2/2016.
 */
@Component
public class ExceptionFactory {

    @Resource
    MessageLocalizator localizator;

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

    protected String getMessage(String msgCode, Object[] args) {
        return localizator.localizeMessage(msgCode, args);
    }
}
