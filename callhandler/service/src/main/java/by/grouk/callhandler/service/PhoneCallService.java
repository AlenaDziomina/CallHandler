package by.grouk.callhandler.service;

import by.grouk.callhandler.dto.PhoneCallDto;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public interface PhoneCallService {
    void addCall(PhoneCallDto call);

    PhoneCallDto createPhoneCall();
}
