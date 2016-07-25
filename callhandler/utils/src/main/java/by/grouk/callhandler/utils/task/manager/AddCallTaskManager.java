package by.grouk.callhandler.utils.task.manager;

import java.util.concurrent.ForkJoinPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.task.AddPhoneCallTask;
import by.grouk.callhandler.utils.template.PhoneCallTemplateUtil;
import by.grouk.callhandler.utils.template.TemplateGeneratorFactory;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/21/2016.
 */
@Component
public class AddCallTaskManager {

    @Autowired
    private ForkJoinPool pool;

    @Autowired
    private TemplateGeneratorFactory generatorFactory;

    @Autowired
    private PhoneCallTemplateUtil templateUtil;

    public void runTask(PhoneCall call) {
        String templateCode = templateUtil.determineTemplateCode(call);
        TemplateGenerator templateGenerator = generatorFactory.getTemplateGenerator(templateCode);
        AddPhoneCallTask addCallTask = new AddPhoneCallTask(call, templateGenerator);
        pool.execute(addCallTask);
    }
}
