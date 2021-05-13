package ar.edu.unq.desapp.grupoh.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;

public interface ClientPlatformRepository extends JpaRepository<ClientPlatform, Long> {

}
