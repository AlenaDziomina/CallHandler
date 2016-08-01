package by.grouk.callhandler.utils.matcher.impl;

import java.util.Date;
import java.util.Properties;

import by.grouk.callhandler.dto.PhoneCallDto;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.matcher.Matcher;
import by.grouk.callhandler.utils.matcher.MatcherComponent;

/**
 * Created by Alena_Grouk on 7/29/2016.
 */
@MatcherComponent(srcClass = PhoneCall.class, destClass = PhoneCallDto.class)
public class PhoneCallMatcher implements Matcher<PhoneCall,PhoneCallDto> {
    @Override
    public PhoneCallDto convert(Properties context, PhoneCall src, PhoneCallDto dest) {
        dest.setFirstName(src.getFirstName());
        dest.setLastName(src.getLastName());
        dest.setPhoneNumber(src.getPhoneNumber());
        return dest;
    }

    @Override
    public PhoneCall convertBack(Properties context, PhoneCallDto src, PhoneCall dest) {
        dest.setFirstName(src.getFirstName());
        dest.setLastName(src.getLastName());
        dest.setPhoneNumber(src.getPhoneNumber());
        dest.setCallDate(new Date());
        return dest;
    }
}
