package in.digiborn.api.notification.models.requests;

import static in.digiborn.api.notification.utils.ErrorMessage.ERR_FIELD_CAN_NOT_BE_BLANK;
import static in.digiborn.api.notification.utils.ErrorMessage.ERR_FIELD_CAN_NOT_BE_EMPTY;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import in.digiborn.api.notification.models.EmailRecipient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
public class BroadcastEmailRequest {

    @Valid
    @NotEmpty(message = ERR_FIELD_CAN_NOT_BE_EMPTY)
    private List<EmailRecipient> to;

    @Valid
    private List<EmailRecipient> cc;

    @Valid
    private List<EmailRecipient> bcc;

    @NotBlank(message = ERR_FIELD_CAN_NOT_BE_BLANK)
    private String title;

    @NotBlank(message = ERR_FIELD_CAN_NOT_BE_BLANK)
    private String body;

}
