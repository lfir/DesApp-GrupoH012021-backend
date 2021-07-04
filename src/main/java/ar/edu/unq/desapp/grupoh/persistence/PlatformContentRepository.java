package ar.edu.unq.desapp.grupoh.persistence;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatformContentRepository extends JpaRepository<PlatformContent, Long>, PlatformContentRepositoryCustom {

    @Query("SELECT c FROM PlatformContent c WHERE c.titleId = :id")
    Optional<PlatformContent> findByIdIMDB(String id);
}
