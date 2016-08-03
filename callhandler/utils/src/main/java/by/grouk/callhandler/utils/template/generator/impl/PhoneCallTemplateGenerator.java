package by.grouk.callhandler.utils.template.generator.impl;

import org.springframework.stereotype.Component;

import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.template.generator.TemplateCode;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */

@Component
@TemplateCode(2)
public class PhoneCallTemplateGenerator extends AbstractCallTemplateGenerator {

    @Override
    protected String generateMessage(PhoneCall phoneCall) {
        StringBuilder message = new StringBuilder(phoneCall.getCallDate().toString())
                .append(separator);
        return message.toString();
    }
}
