package in.digiborn.api.notification.services;

import in.digiborn.api.notification.models.EmailNotification;

public interface EmailNotificationStrategy {
    void send(EmailNotification emailNotification);
}
