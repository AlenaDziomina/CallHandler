package by.grouk.callhandler.service.impl;

import java.util.Properties;

import javax.annotation.Resource;

import by.grouk.callhandler.utils.converter.Converter;

/**
 * Created by Alena_Grouk on 8/1/2016.
 */
public abstract class AbstractService {

    @Resource
    private Converter converter;

    protected Object convert(Properties context, Object src, Class<?> destType){
        return converter.convert(context, src, destType);
    }
}
