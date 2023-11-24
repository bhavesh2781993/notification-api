package in.digiborn.api.notification.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Template {

    private String name;
    private Map<String, String> vars;

}
