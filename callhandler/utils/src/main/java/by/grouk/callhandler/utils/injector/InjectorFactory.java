package by.grouk.callhandler.utils.injector;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.utils.injector.impl.DtoToVoInjector;
import by.grouk.callhandler.utils.injector.impl.VoToDtoInjector;
import by.grouk.callhandler.utils.matcher.Matcher;

/**
 * Created by Alena_Grouk on 8/1/2016.
 */
@Component
public class InjectorFactory {

    @Lookup
    public DtoToVoInjector getDtoToVoInjector(Matcher matcher){
        return new DtoToVoInjector(matcher);
    }

    @Lookup
    public VoToDtoInjector getVoToDtoInjector(Matcher matcher){
        return new VoToDtoInjector(matcher);
    }

    public Map<Class<?>, Map<Class<?>, Injector>> createInjectors(Matcher matcher, Class<?> srcType, Class<?> destType) {

        Map<Class<?>, Map<Class<?>, Injector>> injectors = new HashMap<Class<?>, Map<Class<?>, Injector>>(2){
            {
                put(srcType, new HashMap<Class<?>, Injector>(1){
                    {
                        put(destType, getDtoToVoInjector(matcher));
                    }
                });
                put(destType, new HashMap<Class<?>, Injector>(1){
                    {
                        put(srcType, getVoToDtoInjector(matcher));
                    }
                });
            }
        };

        return injectors;
    }
}
