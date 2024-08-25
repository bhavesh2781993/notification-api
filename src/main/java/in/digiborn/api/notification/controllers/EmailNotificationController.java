package in.digiborn.api.notification.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.digiborn.api.notification.models.requests.BroadcastEmailRequest;
import in.digiborn.api.notification.models.requests.PersonalisedEmailRequest;
import in.digiborn.api.notification.services.EmailNotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Email Notification APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailNotificationController {

    private final EmailNotificationService emailNotificationService;

    @Operation(
        summary = "API to Send Broadcast Email Notification",
        description = "Send email notification to group of people. This behaves as a broadcast and doesn't require template to be created",
        responses = {
            @ApiResponse(description = "Success", responseCode = "204"),
            @ApiResponse(description = "Unauthenticated", responseCode = "401"),
            @ApiResponse(description = "Forbidden", responseCode = "403"),
            @ApiResponse(description = "Internal server error", responseCode = "500")
        }
    )
    @PostMapping("/broadcast")
    public ResponseEntity<Void> sendBroadcastEmail(@RequestBody @Valid final BroadcastEmailRequest broadcastEmailRequest) {
        emailNotificationService.sendBroadcastEmail(broadcastEmailRequest);
        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "API to Send Personal Email Notification",
        description = "Send personalized email notification to group of people. This needs template to be created.",
        responses = {
            @ApiResponse(description = "Success", responseCode = "204"),
            @ApiResponse(description = "Unauthenticated", responseCode = "401"),
            @ApiResponse(description = "Forbidden", responseCode = "403"),
            @ApiResponse(description = "Internal server error", responseCode = "500")
        }
    )
    @PostMapping("/personalized")
    public ResponseEntity<Void> sendPersonalizedEmail(@RequestBody @Valid final PersonalisedEmailRequest personalisedEmailRequest) {
        emailNotificationService.sendPersonalizedEmail(personalisedEmailRequest);
        return ResponseEntity.noContent().build();
    }

}

