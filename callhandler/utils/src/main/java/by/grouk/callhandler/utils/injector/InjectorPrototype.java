package by.grouk.callhandler.utils.injector;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by Alena_Grouk on 8/1/2016.
 */
@Component
@Scope(value="prototype", proxyMode = ScopedProxyMode.NO)
public @interface InjectorPrototype {
}
