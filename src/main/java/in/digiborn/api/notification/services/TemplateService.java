package in.digiborn.api.notification.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import in.digiborn.api.notification.exceptions.ClientNotFoundException;
import in.digiborn.api.notification.models.entities.TemplateEntity;
import in.digiborn.api.notification.repositories.TemplateRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateEntity createTemplate(final TemplateEntity templateEntity) {
        try {
            return templateRepository.save(templateEntity);
        } catch (final DataIntegrityViolationException e) {
            handleFailure(e);
            return null;
        }
    }

    private void handleFailure(final DataIntegrityViolationException e) {
        if (e.getCause() instanceof ConstraintViolationException cve
            && "fk_template_owner_id".equalsIgnoreCase(cve.getConstraintName())) {
            throw new ClientNotFoundException("Invalid template owner");
        }
    }

    @Transactional(readOnly = true)
    public Optional<TemplateEntity> findTemplate(final Long templateId) {
        return templateRepository.findById(templateId);
    }

    public void deleteTemplate(final Long templateId) {
        templateRepository.deleteById(templateId);
    }

}
