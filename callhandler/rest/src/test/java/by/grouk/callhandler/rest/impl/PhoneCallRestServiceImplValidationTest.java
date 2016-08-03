package by.grouk.callhandler.rest.impl;

import by.grouk.callhandler.dto.PhoneCallDto;
import by.grouk.callhandler.rest.PhoneCallRestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.Response;

/**
 * Created by Alena on 02.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testAppContext.xml"})
public class PhoneCallRestServiceImplValidationTest {
    @Autowired
    @Qualifier("testclient")
    private PhoneCallRestService phoneCallRestServiceProxy;

    @Test//(expected = NullPointerException.class)
    public void restTest(){
        PhoneCallDto phoneCallDto = new PhoneCallDto();
        phoneCallRestServiceProxy.addCall(phoneCallDto);
    }

//    @Test//(expected = Exception.class)
//    public void restTestFirstNameNull(){
//        PhoneCallDto phoneCallDto = new PhoneCallDto();
//        phoneCallDto.setLastName("last_name");
//        phoneCallDto.setPhoneNumber("123456789");
//        phoneCallRestServiceProxy.addCall(phoneCallDto);
//    }
//
//    @Test
//    public void restTestFirstNameEmpty(){
//
//        Response response = phoneCallRestServiceProxy.createCall("1");
//        System.out.println(response.toString());
//    }
}
