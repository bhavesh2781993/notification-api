package com.ezbytz.api.notification.models;

import com.ezbytz.api.notification.models.constants.NotificationType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Notification {

    private NotificationType notificationType;
    private String applicationName;
    private String title;
    private Template template;

}
