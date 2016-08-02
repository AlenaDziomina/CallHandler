package by.grouk.callhandler.rest.impl;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import by.grouk.callhandler.dto.PhoneCallDto;
import by.grouk.callhandler.rest.PhoneCallRestService;
import by.grouk.callhandler.rest.RestWebService;
import by.grouk.callhandler.service.PhoneCallService;

/**
 * Created by Alena_Grouk on 7/24/2016.
 */
@Service
@RestWebService
public class PhoneCallRestServiceImpl implements PhoneCallRestService {

    @Resource
    private PhoneCallService phoneCallService;

    public void addCall(@Valid PhoneCallDto call) {
        phoneCallService.addCall(call);
    }

    public Response createCall(String id) {
        return Response.status(Response.Status.OK).entity(phoneCallService.createPhoneCall()).build();
    }
}
