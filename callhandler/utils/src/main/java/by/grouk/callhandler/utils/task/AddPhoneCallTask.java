package by.grouk.callhandler.utils.task;

import java.util.concurrent.RecursiveAction;

import by.grouk.callhandler.model.MessageTemplate;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.template.PhoneCallTemplateUtil;
import by.grouk.callhandler.utils.template.TemplateGeneratorFactory;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class AddPhoneCallTask extends RecursiveAction {

    private PhoneCall phoneCall;

    public AddPhoneCallTask(PhoneCall phoneCall) {
        this.phoneCall = phoneCall;
    }

    @Override protected void compute() {
        int templateCode = PhoneCallTemplateUtil.determineTemplateCode();
        TemplateGenerator templateGenerator = new TemplateGeneratorFactory().getTemplateGenerator(templateCode);
        MessageTemplate template = templateGenerator.generateTemplate(phoneCall);
        //todo
    }
}
