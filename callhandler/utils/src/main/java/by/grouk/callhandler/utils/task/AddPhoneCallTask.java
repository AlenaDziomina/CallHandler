package by.grouk.callhandler.utils.task;

import java.util.concurrent.RecursiveAction;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.model.MessageTemplate;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.template.PhoneCallTemplateUtil;
import by.grouk.callhandler.utils.template.TemplateGeneratorFactory;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;
import by.grouk.callhandler.utils.writer.FileWriter;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
@Component
@Scope(value="prototype", proxyMode = ScopedProxyMode.INTERFACES)
public class AddPhoneCallTask extends RecursiveAction {

    @Resource
    private TemplateGeneratorFactory generatorFactory;

    @Resource
    private PhoneCallTemplateUtil templateUtil;

    @Resource
    private FileWriter fileWriter;

    private PhoneCall phoneCall;

    public AddPhoneCallTask(PhoneCall phoneCall) {
        this.phoneCall = phoneCall;
    }

    @Override protected void compute() {
        String generatorName = templateUtil.determineTemplateCode(phoneCall);
        TemplateGenerator templateGenerator = generatorFactory.getTemplateGenerator(generatorName);
        MessageTemplate template = templateGenerator.generateTemplate(phoneCall);
        fileWriter.write(template);
    }
}
