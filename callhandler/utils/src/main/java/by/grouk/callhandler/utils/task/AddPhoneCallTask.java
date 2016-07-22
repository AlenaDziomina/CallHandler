package by.grouk.callhandler.utils.task;

import java.util.concurrent.RecursiveAction;

import by.grouk.callhandler.model.PhoneCall;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class AddPhoneCallTask extends RecursiveAction {
    private PhoneCall phoneCall;

    public AddPhoneCallTask(PhoneCall phoneCall) {
        this.phoneCall = phoneCall;
    }

    @Override protected void compute() {
        //todo
    }
}
