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

import in.digiborn.api.notification.exceptions.DataNotFoundException;
import in.digiborn.api.notification.mappers.TemplateMapper;
import in.digiborn.api.notification.models.Template;
import in.digiborn.api.notification.models.entities.TemplateEntity;
import in.digiborn.api.notification.services.TemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Template APIs")
@RequiredArgsConstructor
@RestController
@RequestMapping("/templates")
public class TemplateController {

    private final TemplateMapper templateMapper;
    private final TemplateService templateService;

    @Operation(
        summary = "API to Create Template",
        description = "Create template",
        responses = {
            @ApiResponse(description = "Created", responseCode = "201"),
            @ApiResponse(description = "Unauthenticated", responseCode = "401"),
            @ApiResponse(description = "Forbidden", responseCode = "403"),
            @ApiResponse(description = "Internal server error", responseCode = "500")
        }
    )
    @PostMapping
    public ResponseEntity<Template> createTemplate(@RequestBody @Valid final Template template) {
        final TemplateEntity templateEntity = templateMapper.toCustomTemplateEntity(template);
        final TemplateEntity createdTemplateEntity = templateService.createTemplate(templateEntity);
        final Template response = templateMapper.toTemplate(createdTemplateEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
        summary = "API to Fetch Template",
        description = "Fetch template",
        responses = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Unauthenticated", responseCode = "401"),
            @ApiResponse(description = "Forbidden", responseCode = "403"),
            @ApiResponse(description = "Not Found", responseCode = "404"),
            @ApiResponse(description = "Internal server error", responseCode = "500")
        }
    )
    @GetMapping("/{templateId}")
    public ResponseEntity<Template> getTemplate(@PathVariable final Long templateId) {
        final TemplateEntity matchingTemplateEntity = templateService.findTemplate(templateId)
            .orElseThrow(() -> new DataNotFoundException("Template not found with templateId: " + templateId));
        final Template response = templateMapper.toTemplate(matchingTemplateEntity);
        return ResponseEntity.ok(response);
    }

    @Operation(
        summary = "API to Delete Template",
        description = "Delete template",
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
