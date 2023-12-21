package in.digiborn.api.notification.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import in.digiborn.api.notification.models.Template;
import in.digiborn.api.notification.repositories.TemplateRepository;

@RequiredArgsConstructor
@Service
public class TemplateService {

    private final TemplateRepository templateRepository;

    public Template createTemplate(final Template template) {
        return templateRepository.save(template);
    }

    public Optional<Template> getTemplate(final Long templateId) {
        return templateRepository.findById(templateId);
    }

    public void deleteTemplate(final Long templateId) {
        templateRepository.deleteById(templateId);
    }

}
