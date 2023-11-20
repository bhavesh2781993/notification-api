package com.ezbytz.api.notification.services;

import com.ezbytz.api.notification.models.EmailNotification;

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
