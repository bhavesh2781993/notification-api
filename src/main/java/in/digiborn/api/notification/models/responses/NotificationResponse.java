package in.digiborn.api.notification.models.responses;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_EMPTY)
public class NotificationResponse {

    private String message;
    private String errorMessage;

}
