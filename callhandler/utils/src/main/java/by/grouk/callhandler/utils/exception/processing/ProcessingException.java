package by.grouk.callhandler.utils.exception.processing;

import by.grouk.callhandler.utils.exception.ExceptionConstants;

/**
 * Created by Alena_Grouk on 8/1/2016.
 */
public abstract class ProcessingException extends RuntimeException {

    private int errorCode = ExceptionConstants.DEFAULT_EXCEPTION_ERROR_CODE;

    private String localizedUserMessage;

    public ProcessingException() {
        super();
        localizedUserMessage = generateUserMessage(errorCode, this.getClass().getName());
    }

    public ProcessingException(String message) {
        super(message);
        localizedUserMessage = generateUserMessage(errorCode, message);
    }

    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
        localizedUserMessage = generateUserMessage(errorCode, message);
    }

    public ProcessingException(int anErrorCode, String errorMsg) {
        super(errorMsg);
        errorCode = anErrorCode;
        localizedUserMessage = generateUserMessage(anErrorCode, errorMsg);
    }

    public ProcessingException(int anErrorCode, String errorMsg, Throwable cause) {
        super(cause);
        errorCode = anErrorCode;
        localizedUserMessage = generateUserMessage(anErrorCode, errorMsg);
    }

    public ProcessingException(String message, int anErrorCode, String errorMsg, Throwable cause) {
        super(message, cause);
        errorCode = anErrorCode;
        localizedUserMessage = generateUserMessage(anErrorCode, errorMsg);
    }

    public abstract String generateUserMessage(int anErrorCode, String errorMsg);

    public int getErrorCode()
    {
        return errorCode;
    }

    public String getLocalizedUserMessage() {
        return localizedUserMessage;
    }
}
