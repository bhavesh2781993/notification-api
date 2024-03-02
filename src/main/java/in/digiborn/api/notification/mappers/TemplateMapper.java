package in.digiborn.api.notification.mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import in.digiborn.api.notification.models.Template;
import in.digiborn.api.notification.models.entities.TemplateEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    builder = @Builder(disableBuilder = true)
)
public interface TemplateMapper {

    @Mapping(target = "templateOwner.clientId", source = "templateOwnerId")
    TemplateEntity toTemplateEntity(Template template);

    @Mapping(target = "templateOwnerId", source = "templateOwner.clientId")
    Template toTemplate(TemplateEntity templateEntity);

    default TemplateEntity toCustomTemplateEntity(Template template) {
        final TemplateEntity templateEntity = toTemplateEntity(template);
        templateEntity.setBodyVars(template.extractBodyVariables());
        return templateEntity;
    }

}
