package by.grouk.callhandler.dao.impl;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.modules.junit4.PowerMockRunner;

import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.task.manager.AddCallTaskManager;

/**
 * Created by Alena_Grouk on 8/2/2016.
 */
@RunWith(PowerMockRunner.class)
public class PhoneCallDaoImplTest {

    private PhoneCallDaoImpl dao = new PhoneCallDaoImpl();

    private AddCallTaskManager manager;

    @Before
    public void setup() throws Exception {
        manager = mock(AddCallTaskManager.class);
        MemberModifier.field(PhoneCallDaoImpl.class, "manager").set(dao , manager);
    }

    @Test
    public void addCall() throws Exception {
        PhoneCall phoneCall = mock(PhoneCall.class);
        dao.addCall(phoneCall);
        verify(manager).runTask(phoneCall);
    }
}