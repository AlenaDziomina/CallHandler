package by.grouk.callhandler.utils.template.generator;

import by.grouk.callhandler.model.MessageTemplate;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public interface TemplateGenerator<T> {

    MessageTemplate generateTemplate(T object);

}
