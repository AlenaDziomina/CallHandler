package by.grouk.callhandler.utils.task;

import java.util.concurrent.RecursiveAction;

import by.grouk.callhandler.model.MessageTemplate;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class AddPhoneCallTask extends RecursiveAction {

    private PhoneCall phoneCall;
    private TemplateGenerator templateGenerator;

    public AddPhoneCallTask(PhoneCall phoneCall, TemplateGenerator templateGenerator) {
        this.phoneCall = phoneCall;
        this.templateGenerator = templateGenerator;
    }

    @Override protected void compute() {
        MessageTemplate template = templateGenerator.generateTemplate(phoneCall);
        //todo
    }
}
