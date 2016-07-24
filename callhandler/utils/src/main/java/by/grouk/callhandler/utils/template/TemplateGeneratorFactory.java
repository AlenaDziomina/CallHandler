package by.grouk.callhandler.utils.template;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.grouk.callhandler.utils.template.generator.TemplateCode;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
@Component
public class TemplateGeneratorFactory {

    @Autowired
    private List<TemplateGenerator> generators;

    private Map<Integer, TemplateGenerator> generatorMap;

    @Autowired
    @TemplateCode(1)
    TemplateGenerator templateGenerator;

    public TemplateGeneratorFactory() {
        generatorMap = generators.stream()
                .collect(Collectors.toMap(TemplateGenerator::getTemplateCode, g -> g));
    }

    public TemplateGenerator getTemplateGenerator(int templateCode){
        return generatorMap.get(templateCode);
    }
}
