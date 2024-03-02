package in.digiborn.api.notification.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.digiborn.api.notification.exceptions.ClientNotFoundException;
import in.digiborn.api.notification.models.entities.ClientEntity;
import in.digiborn.api.notification.models.requests.ClientRegistrationRequest;
import in.digiborn.api.notification.models.responses.ClientRegistrationResponse;
import in.digiborn.api.notification.services.ClientRegistrationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientRegistrationController {

    private final ClientRegistrationService clientRegistrationService;

    @PostMapping
    public ResponseEntity<ClientRegistrationResponse> registerClient(
        @RequestBody final ClientRegistrationRequest clientRegistrationRequest) {
        final ClientEntity clientEntity = ClientEntity.builder()
            .clientName(clientRegistrationRequest.getClientName())
            .password(ClientEntity.generatePassword())
            .build();

        final ClientEntity registeredClientEntity = clientRegistrationService.register(clientEntity);

        final ClientRegistrationResponse response = ClientRegistrationResponse.builder()
            .clientId(registeredClientEntity.getClientId())
            .clientName(registeredClientEntity.getClientName())
            .password(registeredClientEntity.getPassword())
            .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{clientName}")
    public ResponseEntity<ClientRegistrationResponse> findClient(@PathVariable("clientName") final String clientName) {
        final ClientEntity clientEntity = ClientEntity.builder()
            .clientName(clientName)
            .build();

        final ClientEntity matchingClientEntity = clientRegistrationService.findClientByName(clientEntity)
            .orElseThrow(() -> new ClientNotFoundException("Client not found with clientName: " + clientName));

        final ClientRegistrationResponse response = ClientRegistrationResponse.builder()
            .clientId(matchingClientEntity.getClientId())
            .clientName(matchingClientEntity.getClientName())
            .build();

        return ResponseEntity.ok(response);
    }
}
