package by.grouk.callhandler.utils.template;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.model.PhoneCall;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
@Component
public class PhoneCallTemplateUtil {

    private Map<Integer, String> codeMap;

    @Autowired
    public PhoneCallTemplateUtil(Map<String, TemplateGenerator> generatorMap) {
        this.codeMap = generatorMap.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getValue().getTemplateCode(), Map.Entry::getKey));
    }

    public String determineTemplateCode(PhoneCall call) {
        int code;
        if (call.getPhoneNumber().startsWith("0")){
            code = 1;
        } else {
            code = 2;
        }
        return codeMap.get(code);
    }
}
