package by.grouk.callhandler.utils.task;

import java.util.concurrent.RecursiveAction;

import javax.annotation.Resource;

import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.template.PhoneCallTemplateUtil;
import by.grouk.callhandler.utils.template.generator.TemplateCode;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class AddPhoneCallTask extends RecursiveAction {

    private PhoneCall phoneCall;

    @Resource
    @TemplateCode(1)
    TemplateGenerator templateGenerator;

    public AddPhoneCallTask(PhoneCall phoneCall) {
        this.phoneCall = phoneCall;
    }

    @Override protected void compute() {
        int templateCode = PhoneCallTemplateUtil.determineTemplateCode();
        templateGenerator.generateTemplate(phoneCall);
        //todo
    }
}
