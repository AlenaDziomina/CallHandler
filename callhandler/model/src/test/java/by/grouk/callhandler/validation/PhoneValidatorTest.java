package by.grouk.callhandler.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Alena_Grouk on 8/2/2016.
 */
@RunWith(PowerMockRunner.class)
public class PhoneValidatorTest {

    private PhoneValidator validator;

    private String code = "420";

    @Before
    public void setUp() throws Exception {
        validator = new PhoneValidator();
        MemberModifier.field(PhoneValidator.class, "code").set(validator , code);
    }

    @Test
    public void isValidFalseForNullPhoneNo() throws Exception {
        String phoneNo = null;

        boolean result = validator.isValid(phoneNo, null);

        assertFalse(result);
    }

    @Test
    public void isValidTrueForFirstPattern() throws Exception {
        String phoneNo = "123456789";

        boolean result = validator.isValid(phoneNo, null);

        assertTrue(result);
    }

    @Test
    public void isValidTrueForSecondPattern() throws Exception {
        String phoneNo = "+(420) 111 222 333";

        boolean result = validator.isValid(phoneNo, null);

        assertTrue(result);
    }

    @Test
    public void isValidTrueForThirdPattern() throws Exception {
        String phoneNo = "+(420)-111222333";

        boolean result = validator.isValid(phoneNo, null);

        assertTrue(result);
    }

    @Test
    public void isValidTrueForForthPattern() throws Exception {
        String phoneNo = "+420111222333";

        boolean result = validator.isValid(phoneNo, null);

        assertTrue(result);
    }

    @Test
    public void isValidTrueForFifthPattern() throws Exception {
        String phoneNo = "00420111222333";

        boolean result = validator.isValid(phoneNo, null);

        assertTrue(result);
    }

    @Test
    public void isValidTrueForSixthPattern() throws Exception {
        String phoneNo = "(111) 222 (333)";

        boolean result = validator.isValid(phoneNo, null);

        assertTrue(result);
    }
}