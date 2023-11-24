package in.digiborn.api.notification.models;

import in.digiborn.api.notification.models.constants.NotificationType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class Notification {

    private NotificationType notificationType;
    private String applicationName;
    private String title;
    private Template template;

}
