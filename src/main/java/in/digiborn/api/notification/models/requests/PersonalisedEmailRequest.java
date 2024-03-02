package in.digiborn.api.notification.models.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import in.digiborn.api.notification.models.EmailRecipient;
import in.digiborn.api.notification.models.TemplatedEmailRecipient;

@Getter
@Setter
public class PersonalisedEmailRequest {

    private String title;

    private Long templateId;

    private List<TemplatedEmailRecipient> to;

    private List<EmailRecipient> cc;

    private List<EmailRecipient> bcc;

}
