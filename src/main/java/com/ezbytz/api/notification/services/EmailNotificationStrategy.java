package com.ezbytz.api.notification.services;

import com.ezbytz.api.notification.models.EmailNotification;

public interface EmailNotificationStrategy {

    void send(EmailNotification emailNotification);
}
