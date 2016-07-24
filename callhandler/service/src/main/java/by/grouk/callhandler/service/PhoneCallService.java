package by.grouk.callhandler.service;

import by.grouk.callhandler.model.PhoneCall;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public interface PhoneCallService {
    void addCall(PhoneCall call);

    PhoneCall createPhoneCall();
}
