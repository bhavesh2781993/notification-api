package in.digiborn.api.notification.models.requests;

import static in.digiborn.api.notification.utils.ErrorMessage.ERR_FIELD_CAN_NOT_BE_BLANK;
import static in.digiborn.api.notification.utils.ErrorMessage.ERR_FIELD_CAN_NOT_BE_EMPTY;
import static in.digiborn.api.notification.utils.ErrorMessage.ERR_FIELD_CAN_NOT_BE_NULL;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import in.digiborn.api.notification.models.EmailRecipient;
import in.digiborn.api.notification.models.TemplatedEmailRecipient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class PersonalisedEmailRequest {

    @NotBlank(message = ERR_FIELD_CAN_NOT_BE_BLANK)
    private String title;

    @NotNull(message = ERR_FIELD_CAN_NOT_BE_NULL)
    private Long templateId;

    @NotEmpty(message = ERR_FIELD_CAN_NOT_BE_EMPTY)
    private List<TemplatedEmailRecipient> to;

    private List<EmailRecipient> cc;

    private List<EmailRecipient> bcc;

}
