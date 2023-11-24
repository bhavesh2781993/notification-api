package in.digiborn.api.notification.services;

import in.digiborn.api.notification.models.EmailNotification;

import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
class EmailNotificationContext {

    @Setter
    EmailNotificationStrategy emailNotificationStrategy;

    void send(final EmailNotification emailNotification) {
        emailNotificationStrategy.send(emailNotification);
    }

}
