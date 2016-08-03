package by.grouk.callhandler.service.aspect;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.grouk.callhandler.utils.exception.impl.PublicException;
import by.grouk.callhandler.utils.exception.processing.ServiceProcessingException;
import by.grouk.callhandler.utils.localization.MessageLocalizator;

/**
 * Created by Alena_Grouk on 8/3/2016.
 */
@Aspect
public class LoggingServiceAspect {

    @Resource
    private MessageLocalizator localizator;

    @AfterThrowing(pointcut = "execution(* by.grouk.callhandler.service.impl.PhoneCallServiceImpl.addCall(..))",
            throwing = "exception")
    public void inServiceLayer(final JoinPoint joinPoint, Throwable exception) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.error(joinPoint.getSignature().getName() + "() failed", exception);

        Object[] args;
        if (exception.getClass().isInstance(ServiceProcessingException.class)) {
            int errorCode = ((ServiceProcessingException)exception).getErrorCode();
            args = new Object[]{errorCode};
        } else {
            args = new Object[]{"000"};
        }
        String msg = localizator.localizeMessage("public.exception.internal_error", args);
        PublicException ex = new PublicException(msg, exception);
        throw ex;
    }
}
