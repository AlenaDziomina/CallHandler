package by.grouk.callhandler.utils.matcher.impl;

import java.util.Properties;

import by.grouk.callhandler.utils.exception.ServiceException;
import by.grouk.callhandler.utils.matcher.Matcher;
import by.grouk.callhandler.utils.matcher.MatcherComponent;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
@MatcherComponent(srcClass = ServiceException.class, destClass = Exception.class)
public class ServiceExceptionMatcher implements Matcher<ServiceException, Exception> {
    @Override
    public Exception convert(Properties context, ServiceException src, Exception dest) {
        return null;
    }

    @Override
    public ServiceException convertBack(Properties context, Exception src, ServiceException dest) {
        return null;
    }
}
