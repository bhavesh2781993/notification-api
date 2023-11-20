package com.ezbytz.api.notification.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "notification")
public class NotificationProperties {

    private EmailNotificationProperties email;

    @Getter
    @Setter
    public static class EmailNotificationProperties {
        private String from;
    }
}
