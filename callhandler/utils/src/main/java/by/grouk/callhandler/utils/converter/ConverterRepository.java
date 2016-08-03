package by.grouk.callhandler.utils.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.utils.exception.processing.factory.ConverterExceptionFactory;
import by.grouk.callhandler.utils.injector.Injector;
import by.grouk.callhandler.utils.injector.InjectorFactory;
import by.grouk.callhandler.utils.matcher.Matcher;
import by.grouk.callhandler.utils.matcher.MatcherComponent;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
@Component
public class ConverterRepository {

    private InjectorFactory injectorFactory;
    private ConverterExceptionFactory exceptionFactory;

    private Map<Class<?>, Map<Class<?>, Injector>> matcherMap = new HashMap<>();

    @Autowired
    public ConverterRepository(Set<Matcher> matchers, InjectorFactory injectorFactory,
            ConverterExceptionFactory converterExceptionFactory) {
        this.injectorFactory = injectorFactory;
        this.exceptionFactory = converterExceptionFactory;
        matchers.forEach(matcher -> registerMatcher(matcher));
    }

    private void registerMatcher(Matcher matcher) {
        Class<?> matcherClass = matcher.getClass();
        String matcherClassName = matcherClass.getName();

        MatcherComponent annotation = Optional.ofNullable(matcherClass.getAnnotation(MatcherComponent.class))
                .orElseThrow(exceptionFactory.createMatcherNotAnnotated(matcherClassName));

        Class<?> srcType = Optional.ofNullable(annotation.srcClass())
                .orElseThrow(exceptionFactory.createMatcherNotAnnotatedSrcType(matcherClassName));
        Class<?> destType = Optional.ofNullable(annotation.destClass())
                .orElseThrow(exceptionFactory.createMatcherNotAnnotatedDestType(matcherClassName));

        Map<Class<?>, Map<Class<?>, Injector>> newInjectors = injectorFactory.createInjectors(matcher, srcType, destType);

        newInjectors.forEach((k, map) -> matcherMap.merge(k, map, (map1, map2) -> {
            map2.forEach((n, inj) -> map1.merge(n, inj, (inj1, inj2) -> {
                throw exceptionFactory.createMatcherDuplicateConverterTypes(matcherClassName, k.getName(), n.getName());
            }));
            return map1;
        }));
    }

    public Injector getInjector(Class<?> srcType, Class<?> destType) {
        Map<Class<?>, Injector> injectors = matcherMap.get(destType);
        if (injectors == null) {
            return null;
        }

        Injector injector = injectors.get(srcType);
        if(injector == null) {
            injector = getInjector(srcType.getSuperclass(), destType);
        }

        return injector;
    }
}
