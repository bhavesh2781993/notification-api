package in.digiborn.api.notification.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import in.digiborn.api.notification.exceptions.DataNotFoundException;
import in.digiborn.api.notification.mappers.TemplateMapper;
import in.digiborn.api.notification.models.EmailNotification;
import in.digiborn.api.notification.models.EmailRecipient;
import in.digiborn.api.notification.models.Template;
import in.digiborn.api.notification.models.entities.TemplateEntity;
import in.digiborn.api.notification.models.requests.PersonalisedEmailRequest;

@RequiredArgsConstructor
@Service
public class EmailNotificationService {

    private final EmailNotificationManager emailNotificationManager;
    private final TemplateService templateService;
    private final TemplateMapper templateMapper;

    public void sendGenericEmail(final EmailNotification emailNotification) {
        emailNotificationManager.send(emailNotification);
    }

    public void sendPersonalizedEmail(final PersonalisedEmailRequest personalisedEmailRequest) {
        final TemplateEntity matchingTemplate = templateService.findTemplate(personalisedEmailRequest.getTemplateId())
            .orElseThrow(() -> new DataNotFoundException("Template not found for templateId: " + personalisedEmailRequest.getTemplateId()));
        final Template template = templateMapper.toTemplate(matchingTemplate);

        personalisedEmailRequest.getTo().stream()
            .map(to -> {
                final String body = template.replaceBodyVariables(to.getBodyVars());
                return EmailNotification.builder()
                    .to(List.of(EmailRecipient.builder()
                        .name(to.getName())
                        .email(to.getEmail())
                        .build()))
                    .cc(personalisedEmailRequest.getCc())
                    .bcc(personalisedEmailRequest.getBcc())
                    .title(personalisedEmailRequest.getTitle())
                    .body(body)
                    .build();
            })
            .forEach(emailNotificationManager::send);
    }
}
