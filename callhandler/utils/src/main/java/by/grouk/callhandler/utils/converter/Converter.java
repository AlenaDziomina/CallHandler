package by.grouk.callhandler.utils.converter;

import java.util.Properties;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
public interface Converter {
    Object convert(Properties context, Object src, Class<?> destType);
}
