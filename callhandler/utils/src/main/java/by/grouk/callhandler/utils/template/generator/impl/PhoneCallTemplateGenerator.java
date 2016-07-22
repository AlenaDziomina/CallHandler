package by.grouk.callhandler.utils.template.generator.impl;

import by.grouk.callhandler.model.Content;
import by.grouk.callhandler.model.PhoneCall;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class PhoneCallTemplateGenerator extends AbstractCallTemplateGenerator {

    @Override
    protected Content defineContent(PhoneCall phoneCall) {
        String message = phoneCall.getCallDate().toString();
        Content content = new Content();
        content.setMessage(message);
        return content;
    }
}
