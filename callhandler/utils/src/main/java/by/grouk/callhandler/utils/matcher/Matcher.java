package by.grouk.callhandler.utils.matcher;

import java.util.Properties;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
public interface Matcher<T, V> {

    V convert(Properties context, T src, V dest);
    T convertBack(Properties context, V src, T dest);
}