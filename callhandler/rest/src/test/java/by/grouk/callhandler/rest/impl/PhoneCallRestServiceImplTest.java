package by.grouk.callhandler.rest.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.modules.junit4.PowerMockRunner;

import by.grouk.callhandler.dto.PhoneCallDto;
import by.grouk.callhandler.service.PhoneCallService;

/**
 * Created by Alena_Grouk on 8/2/2016.
 */
@RunWith(PowerMockRunner.class)
public class PhoneCallRestServiceImplTest {

    private PhoneCallRestServiceImpl restService = new PhoneCallRestServiceImpl();

    private PhoneCallService phoneCallService;

    @Before
    public void setup() throws Exception {
        phoneCallService = mock(PhoneCallService.class);
        MemberModifier.field(PhoneCallRestServiceImpl.class, "phoneCallService").set(restService, phoneCallService);
    }

    @Test
    public void addCall() throws Exception {
        PhoneCallDto phoneCall = mock(PhoneCallDto.class);
        restService.addCall(phoneCall);
        verify(phoneCallService).addCall(phoneCall);
    }

    @Test
    public void createCall() throws Exception {
        PhoneCallDto phoneCall = mock(PhoneCallDto.class);
        when(phoneCallService.createPhoneCall()).thenReturn(phoneCall);
        Response response = restService.createCall("1");
        verify(phoneCallService).createPhoneCall();
        assertEquals(200, response.getStatus());
        assertEquals(phoneCall, response.getEntity());
    }
}
