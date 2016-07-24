package by.grouk.callhandler.rest.impl;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.rest.PhoneCallRestService;
import by.grouk.callhandler.service.PhoneCallService;

/**
 * Created by Alena_Grouk on 7/24/2016.
 */
@Service
public class PhoneCallRestServiceImpl implements PhoneCallRestService {

    @Resource
    PhoneCallService phoneCallService;


    public void addCall(PhoneCall call) {
        phoneCallService.addCall(call);
    }

    public Response createCall() {
        Response response = Response.status(Response.Status.OK).entity(phoneCallService.createPhoneCall()).build();
        return response;
    }
}
