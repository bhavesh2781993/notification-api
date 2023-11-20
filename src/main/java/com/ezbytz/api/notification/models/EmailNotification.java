package com.ezbytz.api.notification.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmailNotification extends Notification {

    private List<String> to;
    private List<String> cc;
    private List<String> bcc;

}
