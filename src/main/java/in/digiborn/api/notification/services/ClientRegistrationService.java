package in.digiborn.api.notification.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import in.digiborn.api.notification.models.entities.ClientEntity;
import in.digiborn.api.notification.repositories.ClientRepository;

@RequiredArgsConstructor
@Service
public class ClientRegistrationService {

    private final ClientRepository clientRepository;

    public ClientEntity register(final ClientEntity clientEntity) {
        return clientRepository.save(clientEntity);
    }

    public Optional<ClientEntity> findClientByName(final ClientEntity clientEntity) {
        return clientRepository.findByClientName(clientEntity.getClientName());
    }

}
