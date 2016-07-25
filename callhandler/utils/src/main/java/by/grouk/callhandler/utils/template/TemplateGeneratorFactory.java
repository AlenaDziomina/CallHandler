package by.grouk.callhandler.utils.template;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
@Component
public class TemplateGeneratorFactory {

    @Resource
    private Map<String, TemplateGenerator> generatorMap;

    public TemplateGenerator getTemplateGenerator(String templateCode){
        if (generatorMap != null) {
            return generatorMap.get(templateCode);
        }
        return null;
    }
}
