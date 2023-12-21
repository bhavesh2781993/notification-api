package in.digiborn.api.notification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.digiborn.api.notification.models.Template;

public interface TemplateRepository extends JpaRepository<Template, Long> {
}
