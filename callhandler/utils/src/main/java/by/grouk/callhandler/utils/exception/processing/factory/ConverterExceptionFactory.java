package by.grouk.callhandler.utils.exception.processing.factory;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.utils.exception.processing.ConverterException;

/**
 * Created by Alena_Grouk on 8/2/2016.
 */
@Component
public class ConverterExceptionFactory extends ExceptionFactory {

    public static final int CANNOT_INSTANTIATE = 300;
    public static final int CANNOT_FIND_INJECTOR = 301;
    public static final int DEST_TYPE_CANNOT_BE_NULL = 302;
    public static final int MATCHER_NOT_ANNOTATED = 303;
    public static final int MATCHER_NOT_ANNOTATED_SRC_TYPE = 304;
    public static final int MATCHER_NOT_ANNOTATED_DEST_TYPE = 304;
    public static final int DUPLICATE_CONVERTER_TYPES = 305;

    @Lookup
    public ConverterException getConverterException(int errorCode, String errorMsg){
        return new ConverterException(errorCode, errorMsg);
    }

    @Lookup
    public ConverterException getConverterException(int errorCode, String errorMsg, Throwable e){
        return new ConverterException(errorCode, errorMsg, e);
    }

    public ConverterException createDestTypeCannotBeNull(Object src) {
        Object[] args = new Object[]{src.getClass().getName()};
        String msg = getMessage("converter.dest_type_null", args);
        return getConverterException(DEST_TYPE_CANNOT_BE_NULL, msg);
    }

    public ConverterException createCannotInstantiate(String destType, Throwable e) {
        Object[] args = new Object[]{destType};
        String msg = getMessage("converter.cannot_instantiate", args);
        return getConverterException(CANNOT_INSTANTIATE, msg, e);
    }

    public ConverterException createCannotFindInjector(String srcType, String destType) {
        Object[] args = new Object[]{srcType, destType};
        String msg = getMessage("converter.cannot_find_injector", args);
        return getConverterException(CANNOT_FIND_INJECTOR, msg);
    }

    public Supplier<ConverterException> createMatcherNotAnnotated(String matcherClassName) {
        Object[] args = new Object[]{matcherClassName};
        String msg = getMessage("converter.matcher_not_annotated", args);
        return () -> getConverterException(MATCHER_NOT_ANNOTATED, msg);
    }

    public Supplier<ConverterException> createMatcherNotAnnotatedSrcType(String matcherClassName) {
        Object[] args = new Object[]{matcherClassName};
        String msg = getMessage("converter.matcher_not_annotated.src_type", args);
        return () -> getConverterException(MATCHER_NOT_ANNOTATED_SRC_TYPE, msg);
    }

    public Supplier<ConverterException> createMatcherNotAnnotatedDestType(String matcherClassName) {
        Object[] args = new Object[]{matcherClassName};
        String msg = getMessage("converter.matcher_not_annotated.dest_type", args);
        return () -> getConverterException(MATCHER_NOT_ANNOTATED_DEST_TYPE, msg);
    }

    public ConverterException createMatcherDuplicateConverterTypes(String matcherClassName, String srcType, String destType) {
        Object[] args = new Object[]{matcherClassName, srcType, destType};
        String msg = getMessage("converter.duplicate_converter_types", args);
        return getConverterException(DUPLICATE_CONVERTER_TYPES, msg);
    }
}
