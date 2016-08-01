package by.grouk.callhandler.utils.converter.impl;

import java.util.Properties;

import by.grouk.callhandler.utils.converter.Converter;
import by.grouk.callhandler.utils.injector.Injector;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
public abstract class AbstractConverter implements Converter {

    @Override
    public Object convert(Properties context, Object src, Class<?> destType) {
        if (src == null || destType == null) {
            throw new RuntimeException(); //todo
        }

        try {
            Object dest = destType.newInstance();
            dest = inject(context, src, destType, dest);
            return dest;
        } catch (Exception e) {
            throw new RuntimeException(); //todo
        }
    }

    private Object inject(Properties context, Object src, Class<?> destType, Object dest) {
        Injector injector = selectInjector(src.getClass(), destType);
        if(injector == null) {
            throw new RuntimeException(); //todo
        }
        dest = injector.inject(context, src, dest);
        return dest;
    }

    protected abstract Injector selectInjector(Class<?> aClass, Class<?> destType);
}
