package in.digiborn.api.notification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.digiborn.api.notification.models.entities.TemplateEntity;

public interface TemplateRepository extends JpaRepository<TemplateEntity, Long> {
}
