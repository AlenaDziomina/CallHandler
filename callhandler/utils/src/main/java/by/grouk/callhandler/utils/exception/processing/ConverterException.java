package by.grouk.callhandler.utils.exception.processing;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by Alena_Grouk on 8/2/2016.
 */
@Component
@Scope(value="prototype", proxyMode = ScopedProxyMode.NO)
public class ConverterException extends ServiceProcessingException {
    public ConverterException() {}

    public ConverterException(int anErrorCode, String errorMsg) {
        super(anErrorCode, errorMsg);
    }

    public ConverterException(int anErrorCode, String errorMsg, Throwable cause) {
        super(anErrorCode, errorMsg, cause);
    }
}
