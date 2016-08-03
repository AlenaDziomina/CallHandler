package by.grouk.callhandler.utils.converter.impl;

import java.util.Properties;

import javax.annotation.Resource;

import by.grouk.callhandler.utils.converter.Converter;
import by.grouk.callhandler.utils.exception.processing.factory.ConverterExceptionFactory;
import by.grouk.callhandler.utils.injector.Injector;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
public abstract class AbstractConverter implements Converter {

    @Resource(name = "converterExceptionFactory")
    protected ConverterExceptionFactory exceptionFactory;

    @Override
    public Object convert(Properties context, Object src, Class<?> destType) {
        if (src == null) {
            return null;
        }

        if (destType == null) {
            throw exceptionFactory.createDestTypeCannotBeNull(src);
        }

        try {
            Object dest = destType.newInstance();
            dest = inject(context, src, destType, dest);
            return dest;
        } catch (InstantiationException | IllegalAccessException e) {
            throw exceptionFactory.createCannotInstantiate(destType.getName(), e);
        }
    }

    private Object inject(Properties context, Object src, Class<?> destType, Object dest) {
        Injector injector = selectInjector(src.getClass(), destType);
        if(injector == null) {
            throw exceptionFactory.createCannotFindInjector(src.getClass().getName(), destType.getName());
        }
        dest = injector.inject(context, src, dest);
        return dest;
    }

    protected abstract Injector selectInjector(Class<?> aClass, Class<?> destType);
}
