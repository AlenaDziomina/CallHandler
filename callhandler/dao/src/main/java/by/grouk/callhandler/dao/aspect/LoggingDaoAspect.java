package by.grouk.callhandler.dao.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Alena_Grouk on 8/3/2016.
 */
@Aspect
public class LoggingDaoAspect {
    @AfterThrowing(pointcut = "execution(* by.grouk.callhandler.dao.impl.PhoneCallDaoImpl.addCall(..))",
            throwing = "exception")
    public void inWebLayer(final JoinPoint joinPoint, Throwable exception) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.error(joinPoint.getSignature().getName() + "() failed", exception);
    }
}
