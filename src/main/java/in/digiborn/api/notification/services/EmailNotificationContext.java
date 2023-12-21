package in.digiborn.api.notification.services;

import lombok.Setter;
import org.springframework.stereotype.Service;

import in.digiborn.api.notification.models.EmailNotification;

@Service
class EmailNotificationContext {

    @Setter
    EmailNotificationStrategy emailNotificationStrategy;

    void send(final EmailNotification emailNotification) {
        emailNotificationStrategy.send(emailNotification);
    }

}
