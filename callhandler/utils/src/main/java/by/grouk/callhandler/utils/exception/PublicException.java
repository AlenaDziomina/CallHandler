package by.grouk.callhandler.utils.exception;

import java.util.Map;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
public class PublicException extends RuntimeException {

    private static final long serialVersionUID = 8634456051135426741L;

    public static final String SEVERITY_ERROR = ExceptionConstants.SEVERITY_ERROR;
    public static final String SEVERITY_WARNING = ExceptionConstants.SEVERITY_WARNING;
    public static final String SEVERITY_INFO = ExceptionConstants.SEVERITY_INFO;

    private int errorCode = 0;

    private String exceptionClass;

    private String severity = SEVERITY_ERROR;

    private Map<String, Object> parameters = null;

    public PublicException() {
        super();
    }

    public PublicException(String message) {
        super(message);
    }

    public PublicException(String message, Throwable ex) {
        super(message, ex);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getExceptionClass() {
        return exceptionClass;
    }

    public void setExceptionClass(String exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
