package by.grouk.callhandler.utils.injector.impl;

import java.util.Properties;

import by.grouk.callhandler.utils.injector.Injector;
import by.grouk.callhandler.utils.injector.InjectorPrototype;
import by.grouk.callhandler.utils.matcher.Matcher;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
@InjectorPrototype
public class VoToDtoInjector implements Injector {

    private Matcher matcher;

    public VoToDtoInjector(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public Object inject(Properties context, Object src, Object dest) {
        return matcher.convert(context, src, dest);
    }
}
