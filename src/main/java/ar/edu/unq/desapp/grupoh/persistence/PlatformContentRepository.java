package ar.edu.unq.desapp.grupoh.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;

public interface PlatformContentRepository extends JpaRepository<PlatformContent, Long>, PlatformContentRepositoryCustom {

}
