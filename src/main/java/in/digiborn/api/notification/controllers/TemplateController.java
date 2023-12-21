package in.digiborn.api.notification.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.digiborn.api.notification.exceptions.TemplateException;
import in.digiborn.api.notification.models.Template;
import in.digiborn.api.notification.services.TemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Template APIs")
@RequiredArgsConstructor
@RestController
@RequestMapping("/templates")
public class TemplateController {

    private final TemplateService templateService;

    @Operation(
        summary = "API to Create Template",
        description = "Create Template",
        responses = {
            @ApiResponse(description = "Success", responseCode = "204"),
            @ApiResponse(description = "Unauthenticated", responseCode = "401"),
            @ApiResponse(description = "Forbidden", responseCode = "403"),
            @ApiResponse(description = "Internal server error", responseCode = "500")
        }
    )
    @PostMapping
    public ResponseEntity<Template> createTemplate(@RequestBody final Template template) {
        final Template createdTemplate = templateService.createTemplate(template);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTemplate);
    }

    @Operation(
        summary = "API to Fetch Template",
        description = "Fetch Template",
        responses = {
            @ApiResponse(description = "Success", responseCode = "204"),
            @ApiResponse(description = "Unauthenticated", responseCode = "401"),
            @ApiResponse(description = "Forbidden", responseCode = "403"),
            @ApiResponse(description = "Internal server error", responseCode = "500")
        }
    )
    @GetMapping("/{templateId}")
    public ResponseEntity<Template> getTemplate(@PathVariable final Long templateId) {
        final Template matchingTemplate = templateService.getTemplate(templateId)
            .orElseThrow(() -> new TemplateException("Template not found with templateId: " + templateId));
        return ResponseEntity.ok(matchingTemplate);
    }

    @Operation(
        summary = "API to Delete Template",
        description = "Delete Template",
        responses = {
            @ApiResponse(description = "Success", responseCode = "204"),
            @ApiResponse(description = "Unauthenticated", responseCode = "401"),
            @ApiResponse(description = "Forbidden", responseCode = "403"),
            @ApiResponse(description = "Internal server error", responseCode = "500")
        }
    )
    @DeleteMapping("/{templateId}")
    public ResponseEntity<Void> deleteTemplate(@PathVariable final Long templateId) {
        templateService.deleteTemplate(templateId);
        return ResponseEntity.noContent().build();
    }

}
