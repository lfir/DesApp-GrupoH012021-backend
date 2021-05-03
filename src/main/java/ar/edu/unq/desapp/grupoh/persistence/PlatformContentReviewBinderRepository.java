package ar.edu.unq.desapp.grupoh.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.edu.unq.desapp.grupoh.model.PlatformContentReviewBinder;

public interface PlatformContentReviewBinderRepository extends JpaRepository<PlatformContentReviewBinder, Long> {
	@Query("SELECT b FROM PlatformContentReviewBinder b WHERE b.platformContent.titleId =:titleId")
	PlatformContentReviewBinder findByContentImdbId(@Param("titleId") String titleId);
}
