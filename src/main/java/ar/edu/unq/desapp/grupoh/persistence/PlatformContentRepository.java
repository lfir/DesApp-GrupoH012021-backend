package ar.edu.unq.desapp.grupoh.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;

@Repository
public interface PlatformContentRepository extends JpaRepository<PlatformContent, Long>, PlatformContentRepositoryCustom {

}
