package in.digiborn.api.notification.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TemplatedEmailRecipient extends EmailRecipient {

    private Map<String, String> bodyVars;

}
