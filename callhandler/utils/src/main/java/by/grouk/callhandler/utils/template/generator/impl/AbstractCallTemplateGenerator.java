package by.grouk.callhandler.utils.template.generator.impl;

import org.springframework.beans.factory.annotation.Value;

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

    @Value("#{systemProperties['line.separator']}")
    protected String separator;

    @Value("#{config['phonecall.file.directory']}")
    protected String directory;

    @Value("#{config['phonecall.file.format']}")
    protected String format;

    @Value("#{config['phonecall.file.charset']}")
    protected String charset;

    abstract protected String generateMessage(PhoneCall phoneCall);

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
        Destination destination = new Destination();
        String fileName = generateFileName(phoneCall);
        destination.setFileName(fileName);
        destination.setFilePath(generateFilePath(fileName));
        destination.setCharset(charset);
        return destination;
    }

    protected String generateFileName(PhoneCall phoneCall){
        StringBuilder fileName = new StringBuilder(phoneCall.getFirstName())
                .append(TemplateConstants.UNDERLINE)
                .append(phoneCall.getLastName());
        return fileName.toString();
    }

    protected String generateFilePath(String fileName){
        StringBuilder filePath = new StringBuilder(directory)
                .append(fileName)
                .append(format);
        return filePath.toString();
    }

    protected Content defineContent(PhoneCall phoneCall) {
        Content content = new Content();
        content.setHeader(generateHeader(phoneCall));
        content.setMessage(generateMessage(phoneCall));
        return content;
    }

    protected String generateHeader(PhoneCall phoneCall) {
        StringBuilder header = new StringBuilder(phoneCall.getPhoneNumber())
                .append(separator);
        return header.toString();
    }
}
