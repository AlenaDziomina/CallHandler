package by.grouk.callhandler.service.impl;

import by.grouk.callhandler.dao.PhoneCallDao;
import by.grouk.callhandler.dto.PhoneCallDto;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.converter.Converter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by Alena on 03.08.2016.
 */
@RunWith(PowerMockRunner.class)
public class PhoneCallServiceImplTest {

    private PhoneCallServiceImpl service;
    private PhoneCallDao phoneCallDao;
    private Converter converter;

    @Before
    public void setup() throws Exception {
        service = new PhoneCallServiceImpl();
        phoneCallDao = mock(PhoneCallDao.class);
        converter = mock(Converter.class);
        MemberModifier.field(PhoneCallServiceImpl.class, "phoneCallDao").set(service , phoneCallDao);
        MemberModifier.field(PhoneCallServiceImpl.class, "converter").set(service , converter);
    }

    @Test
    public void addCall() throws Exception {
        PhoneCallDto phoneCallDto = mock(PhoneCallDto.class);
        PhoneCall phoneCall = mock(PhoneCall.class);
        when(converter.convert(null, phoneCallDto, PhoneCall.class)).thenReturn(phoneCall);
        service.addCall(phoneCallDto);
        verify(phoneCallDao).addCall(phoneCall);
    }

}