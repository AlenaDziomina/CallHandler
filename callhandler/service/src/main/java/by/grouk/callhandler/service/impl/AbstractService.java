package by.grouk.callhandler.service.impl;

import java.util.Properties;

import javax.annotation.Resource;

import by.grouk.callhandler.utils.converter.Converter;
import by.grouk.callhandler.utils.exception.ServiceException;

/**
 * Created by Alena_Grouk on 8/1/2016.
 */
public abstract class AbstractService {

    @Resource
    private Converter converter;

    protected Object convert(Properties context, Object src, Class<?> destType){
        return converter.convert(context, src, destType);
    }

    protected void processException(Exception e, boolean toBeLogged, String logMessage) {
        if (toBeLogged) {//todo
//            logException(e, logMessage);
//            logException(e, e.getStackTrace().toString());
        }
        ServiceException ex = (ServiceException) convert(null, e, ServiceException.class);
        throw ex;
    }
}
