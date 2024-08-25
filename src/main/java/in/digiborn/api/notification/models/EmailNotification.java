package in.digiborn.api.notification.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

import in.digiborn.api.notification.utils.ErrorMessage;
import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EmailNotification extends Notification {

    @NotEmpty(message = ErrorMessage.ERR_FIELD_CAN_NOT_BE_EMPTY)
    private List<EmailRecipient> to;

    private List<EmailRecipient> cc;

    private List<EmailRecipient> bcc;

    private String body;

    public List<String> getToEmailIds() {
        return extractEmailList(to);
    }

    public List<String> getCCEmailIds() {
        return extractEmailList(cc);
    }

    public List<String> getBCCEmailIds() {
        return extractEmailList(bcc);
    }

    private List<String> extractEmailList(final List<EmailRecipient> recipients) {
        if (!CollectionUtils.isEmpty(recipients)) {
            return recipients.stream()
                .map(EmailRecipient::getEmail)
                .toList();
        }
        return Collections.emptyList();
    }

}
