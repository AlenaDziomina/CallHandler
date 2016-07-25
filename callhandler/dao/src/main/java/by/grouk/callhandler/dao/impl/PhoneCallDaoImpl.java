package by.grouk.callhandler.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import by.grouk.callhandler.dao.PhoneCallDao;
import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.task.manager.AddCallTaskManager;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
@Repository
public class PhoneCallDaoImpl implements PhoneCallDao {

    @Resource
    private AddCallTaskManager manager;

    public void addCall(PhoneCall call) {
        manager.runTask(call);
        //todo
    }
}
