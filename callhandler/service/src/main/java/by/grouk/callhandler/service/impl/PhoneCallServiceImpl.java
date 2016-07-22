package by.grouk.callhandler.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import by.grouk.callhandler.dao.PhoneCallDao;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.service.PhoneCallService;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
@Repository
public class PhoneCallServiceImpl implements PhoneCallService {
    @Resource
    PhoneCallDao phoneCallDao;

    public void addCall(PhoneCall call) {
        phoneCallDao.addCall(call);
    }
}
