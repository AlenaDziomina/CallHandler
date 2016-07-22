package by.grouk.callhandler.utils.template.generator.impl;

import org.springframework.stereotype.Component;

import by.grouk.callhandler.model.Content;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.template.TemplateConstants;
import by.grouk.callhandler.utils.template.generator.TemplateCode;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */

@Component
@TemplateCode(2)
public class CallbackTemplateGenerator extends AbstractCallTemplateGenerator {

    @Override
    protected Content defineContent(PhoneCall phoneCall) {
        String message = phoneCall.getCallDate().toString() + TemplateConstants.CALLBACK;
        Content content = new Content();
        content.setMessage(message);
        return content;
    }
}
