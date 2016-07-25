package by.grouk.callhandler.utils.task.manager;

import java.util.concurrent.ForkJoinPool;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.task.AddPhoneCallTask;

/**
 * Created by Alena_Grouk on 7/21/2016.
 */
@Component
public class AddCallTaskManager {

    @Autowired
    private ForkJoinPool pool;

    @Lookup
    public AddPhoneCallTask getAddCallTask(PhoneCall call){
        return new AddPhoneCallTask(call);
    }

    public void runTask(PhoneCall call) {
        AddPhoneCallTask addCallTask = getAddCallTask(call);
        pool.execute(addCallTask);
    }
}
