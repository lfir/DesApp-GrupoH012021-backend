package ar.edu.unq.desapp.grupoh.persistence;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformContentRepository extends JpaRepository<PlatformContent, Long>, PlatformContentRepositoryCustom {
}
