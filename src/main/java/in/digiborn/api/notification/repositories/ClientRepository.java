package in.digiborn.api.notification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import in.digiborn.api.notification.models.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, String> {

    Optional<ClientEntity> findByClientName(String clientName);

}
