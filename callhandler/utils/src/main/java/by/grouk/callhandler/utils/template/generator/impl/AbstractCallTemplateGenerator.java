package by.grouk.callhandler.utils.template.generator.impl;

import by.grouk.callhandler.model.Content;
import by.grouk.callhandler.model.Destination;
import by.grouk.callhandler.model.MessageTemplate;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.template.TemplateConstants;
import by.grouk.callhandler.utils.template.generator.TemplateCode;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public abstract class AbstractCallTemplateGenerator implements TemplateGenerator<PhoneCall> {

    abstract protected Content defineContent(PhoneCall phoneCall);

    @Override
    public int getTemplateCode(){
        return getClass().getAnnotation(TemplateCode.class).value();
    }

    @Override
    public MessageTemplate generateTemplate(PhoneCall phoneCall) {
        MessageTemplate messageTemplate = new MessageTemplate();
        messageTemplate.setDestination(defineDestination(phoneCall));
        messageTemplate.setContent(defineContent(phoneCall));
        return messageTemplate;
    }

    protected Destination defineDestination(PhoneCall phoneCall) {
        StringBuilder fileName = new StringBuilder(phoneCall.getFirstName())
                .append(TemplateConstants.UNDERLINE)
                .append(phoneCall.getLastName());
        Destination destination = new Destination();
        destination.setFileName(fileName.toString());
        return destination;
    }
}
