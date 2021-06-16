package ar.edu.unq.desapp.grupoh.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;

@Repository
public interface ClientPlatformRepository extends JpaRepository<ClientPlatform, Long> {
	@Query("SELECT c FROM ClientPlatform c WHERE c.apiKey = :apiKey")
	Optional<ClientPlatform> findByApiKey(String apiKey);
	
	@Query("SELECT c FROM ClientPlatform c WHERE c.username = :username")
	Optional<ClientPlatform> findByUsername(String username);
}
