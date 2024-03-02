package in.digiborn.api.notification.models;

import static in.digiborn.api.notification.utils.ErrorMessage.ERR_FIELD_CAN_NOT_BE_BLANK;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailRecipient {

    private String name;

    @NotBlank(message = ERR_FIELD_CAN_NOT_BE_BLANK)
    private String email;

}
