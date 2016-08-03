package by.grouk.callhandler.utils.exception.impl;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
public class ServiceException extends PublicException {

    private static final long serialVersionUID = 8634456051135426742L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable ex) {
        super(message, ex);
    }

    public ServiceException(String message) {
        super(message);
    }

}
