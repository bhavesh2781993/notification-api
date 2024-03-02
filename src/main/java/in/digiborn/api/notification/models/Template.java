package in.digiborn.api.notification.models;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import freemarker.core.InvalidReferenceException;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import in.digiborn.api.notification.exceptions.TemplateFormatException;
import in.digiborn.api.notification.utils.ErrorMessage;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class Template {

    @JsonProperty(access = READ_ONLY)
    private Long templateId;

    @NotBlank(message = ErrorMessage.ERR_FIELD_CAN_NOT_BE_BLANK)
    private String templateOwnerId;

    @NotBlank(message = ErrorMessage.ERR_FIELD_CAN_NOT_BE_BLANK)
    private String name;

    @NotBlank(message = ErrorMessage.ERR_FIELD_CAN_NOT_BE_BLANK)
    private String body;

    public String replaceBodyVariables(final Map<String, String> variables) {
        final freemarker.template.Template freemarkerTemplate = getFreemarkerTemplate(body);

        try (StringWriter stringWriter = new StringWriter()) {
            freemarkerTemplate.process(variables, stringWriter);
            return stringWriter.toString();
        } catch (TemplateException | IOException e) {
            throw new TemplateFormatException("Failed to replace body variables");
        }
    }

    public Set<String> extractBodyVariables() {
        final freemarker.template.Template freemarkerTemplate = getFreemarkerTemplate(body);
        return extractVariables(freemarkerTemplate);
    }

    private freemarker.template.Template getFreemarkerTemplate(final String template) {
        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        try {
            return new freemarker.template.Template(
                "dynamicTemplate",
                new StringReader(template),
                configuration);
        } catch (final IOException e) {
            throw new TemplateFormatException("Invalid template format");
        }
    }

    private Set<String> extractVariables(final freemarker.template.Template template) {
        final Map<String, Object> dataModel = new HashMap<>();
        final Set<String> extractedVariables = new HashSet<>();
        boolean exceptionCaught;

        do {
            exceptionCaught = false;
            try (StringWriter stringWriter = new StringWriter()) {
                template.process(dataModel, stringWriter);
            } catch (final InvalidReferenceException e) {
                exceptionCaught = true;
                dataModel.put(e.getBlamedExpressionString(), "");
                extractedVariables.add(e.getBlamedExpressionString());
            } catch (IOException | TemplateException e) {
                throw new TemplateFormatException("Failed to Load Template: " + template);
            }
        } while (exceptionCaught);

        return extractedVariables;
    }

}
