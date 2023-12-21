package in.digiborn.api.notification.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.digiborn.api.notification.models.EmailNotification;
import in.digiborn.api.notification.services.EmailNotificationManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
@Tag(name = "Email Notification APIs")
public class EmailNotificationController {

    private final EmailNotificationManager emailNotificationManager;

    @Operation(
        summary = "API to Send Email Notification",
        description = "Send Email Notification",
        responses = {
            @ApiResponse(description = "Success", responseCode = "204"),
            @ApiResponse(description = "Unauthenticated", responseCode = "401"),
            @ApiResponse(description = "Forbidden", responseCode = "403"),
            @ApiResponse(description = "Internal server error", responseCode = "500")
        }
    )
    @PostMapping("/send")
    public ResponseEntity<Void> sendEmail(@RequestBody final EmailNotification emailNotification) {
        emailNotificationManager.send(emailNotification);
        return ResponseEntity.noContent().build();
    }
}

