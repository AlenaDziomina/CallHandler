package by.grouk.callhandler.service;

import by.grouk.callhandler.dto.PhoneCallDto;
import by.grouk.callhandler.model.PhoneCall;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public interface PhoneCallService {
    void addCall(PhoneCallDto call);

    PhoneCall createPhoneCall();
}
