package by.grouk.callhandler.utils.task;

import java.util.concurrent.RecursiveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.model.MessageTemplate;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.template.PhoneCallTemplateUtil;
import by.grouk.callhandler.utils.template.TemplateGeneratorFactory;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
@Component
@Scope("prototype")
public class AddPhoneCallTask extends RecursiveAction {

    @Autowired
    private TemplateGeneratorFactory generatorFactory;

    @Autowired
    private PhoneCallTemplateUtil templateUtil;

    private PhoneCall phoneCall;


    public AddPhoneCallTask(PhoneCall phoneCall) {
        this.phoneCall = phoneCall;
    }

    @Override protected void compute() {
        String templateCode = templateUtil.determineTemplateCode(phoneCall);
        TemplateGenerator templateGenerator = generatorFactory.getTemplateGenerator(templateCode);
        MessageTemplate template = templateGenerator.generateTemplate(phoneCall);
        //todo
    }
}
