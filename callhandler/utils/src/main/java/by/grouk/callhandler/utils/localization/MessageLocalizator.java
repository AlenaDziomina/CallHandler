package by.grouk.callhandler.utils.localization;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * Created by Alena_Grouk on 8/3/2016.
 */
@Component
public class MessageLocalizator {
    @Resource(name = "error_strings")
    private MessageSource messageSource;

    @Value("#{config['language']}")
    private String language;

    private Locale getLocale() {
        return new Locale(language);
    }

    public String localizeMessage(String msgCode, Object[] args) {
        return messageSource.getMessage(msgCode, args, getLocale());
    }

    public String localizeMessage(String msgCode) {
        return messageSource.getMessage(msgCode, null, getLocale());
    }
}
