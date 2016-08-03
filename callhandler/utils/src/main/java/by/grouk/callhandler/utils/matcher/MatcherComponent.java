package by.grouk.callhandler.utils.matcher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Alena_Grouk on 8/1/2016.
 */
@Target({ ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Component
public @interface MatcherComponent {

    Class<?> srcClass();

    Class<?> destClass();
}
