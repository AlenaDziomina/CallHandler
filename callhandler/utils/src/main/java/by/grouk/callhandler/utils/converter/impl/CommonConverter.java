package by.grouk.callhandler.utils.converter.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import by.grouk.callhandler.utils.converter.ConverterRepository;
import by.grouk.callhandler.utils.injector.Injector;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
@Component
public class CommonConverter extends AbstractConverter {

    @Resource
    ConverterRepository converterRepository;

    @Override
    protected Injector selectInjector(Class<?> srcType, Class<?> destType) {
        Injector injector = converterRepository.getInjector(srcType, destType);
        return injector;
    }
}
