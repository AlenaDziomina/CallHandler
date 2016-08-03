package by.grouk.callhandler.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Alena_Grouk on 7/26/2016.
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Value("#{config['phonecall.code']}")
    private String code;

    @Override
    public void initialize(Phone paramA) {
    }

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
        if(phoneNo == null){
            return false;
        }

        return phoneNo.matches("\\d{9}") //123456789
                || phoneNo.matches("\\+\\(" + code + "\\) \\d{3} \\d{3} \\d{3}") //+(420) 111 222 333
                || phoneNo.matches("\\+\\(" + code + "\\)-\\d{9}")  //+(420)-111222333
                || phoneNo.matches("\\+" + code + "\\d{9}")         //+420111222333
                || phoneNo.matches("0{2}" + code + "\\d{9}")        //00420111222333
                || phoneNo.matches("\\(\\d{3}\\) \\d{3} \\(\\d{3}\\)"); //(111) 222 (333)
    }

}
