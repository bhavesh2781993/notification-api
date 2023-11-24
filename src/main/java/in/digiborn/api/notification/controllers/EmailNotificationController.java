package in.digiborn.api.notification.controllers;

import in.digiborn.api.notification.models.EmailNotification;
import in.digiborn.api.notification.services.EmailNotificationManager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailNotificationController {

    private final EmailNotificationManager emailNotificationManager;

    @PostMapping("/send")
    public ResponseEntity<Void> sendEmail(@RequestBody final EmailNotification emailNotification) {
        emailNotificationManager.send(emailNotification);
        return ResponseEntity.noContent().build();
    }
}

