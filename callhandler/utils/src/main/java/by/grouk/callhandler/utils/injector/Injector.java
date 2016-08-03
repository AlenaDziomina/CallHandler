package by.grouk.callhandler.utils.injector;

import java.util.Properties;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
public interface Injector {
    Object inject(Properties context, Object src, Object dest);
}
