package in.digiborn.api.notification.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import in.digiborn.api.notification.models.enums.NotificationType;
import in.digiborn.api.notification.utils.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class Notification {

    @NotNull(message = ErrorMessage.ERR_FIELD_CAN_NOT_BE_NULL)
    private NotificationType notificationType;

    @NotBlank(message = ErrorMessage.ERR_FIELD_CAN_NOT_BE_BLANK)
    private String title;

}
