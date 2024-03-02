package in.digiborn.api.notification.services;

import static org.springframework.transaction.annotation.Isolation.SERIALIZABLE;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import in.digiborn.api.notification.models.entities.TemplateEntity;
import in.digiborn.api.notification.repositories.TemplateRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class TemplateService {

    private final TemplateRepository templateRepository;

    @Transactional(isolation = SERIALIZABLE)
    public TemplateEntity createTemplate(final TemplateEntity templateEntity) {
        return templateRepository.save(templateEntity);
    }

    @Transactional(readOnly = true)
    public Optional<TemplateEntity> findTemplate(final Long templateId) {
        return templateRepository.findById(templateId);
    }

    public void deleteTemplate(final Long templateId) {
        templateRepository.deleteById(templateId);
    }

}
