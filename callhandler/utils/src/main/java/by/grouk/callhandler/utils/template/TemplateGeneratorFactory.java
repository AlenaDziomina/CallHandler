package by.grouk.callhandler.utils.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import by.grouk.callhandler.utils.template.generator.TemplateCode;
import by.grouk.callhandler.utils.template.generator.TemplateGenerator;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class TemplateGeneratorFactory {

    @Autowired
    private List<TemplateGenerator> generators;

    @Autowired
    @TemplateCode(1)
    TemplateGenerator templateGenerator;

    public TemplateGenerator getTemplateGenerator(){
        return templateGenerator;
    }
}
