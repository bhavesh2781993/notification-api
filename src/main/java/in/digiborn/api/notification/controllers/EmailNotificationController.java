package in.digiborn.api.notification.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.digiborn.api.notification.models.requests.GenericEmailRequest;
import in.digiborn.api.notification.models.requests.PersonalisedEmailRequest;
import in.digiborn.api.notification.services.EmailNotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
@Tag(name = "Email Notification APIs")
public class EmailNotificationController {

    private final EmailNotificationService emailNotificationService;


    @Operation(
        summary = "API to Send Email Notification",
        description = "Send email notification",
        responses = {
            @ApiResponse(description = "Success", responseCode = "204"),
            @ApiResponse(description = "Unauthenticated", responseCode = "401"),
            @ApiResponse(description = "Forbidden", responseCode = "403"),
            @ApiResponse(description = "Internal server error", responseCode = "500")
        }
    )
    @PostMapping("/generic")
    public ResponseEntity<Void> sendGenericEmail(@RequestBody @Valid final GenericEmailRequest genericEmailRequest) {
        emailNotificationService.sendGenericEmail(genericEmailRequest);
        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "API to Send Email Notification",
        description = "Send email notification",
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

