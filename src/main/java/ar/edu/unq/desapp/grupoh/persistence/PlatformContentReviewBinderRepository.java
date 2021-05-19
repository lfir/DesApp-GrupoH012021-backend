package ar.edu.unq.desapp.grupoh.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.edu.unq.desapp.grupoh.model.PlatformContentReviewBinder;

public interface PlatformContentReviewBinderRepository extends JpaRepository<PlatformContentReviewBinder, Long> {
	@Query("SELECT b FROM PlatformContentReviewBinder b WHERE b.platformContent.titleId = :titleId")
	PlatformContentReviewBinder findByContentImdbId(@Param("titleId") String titleId);
	
	@Query("SELECT b.id FROM PlatformContentReviewBinder b JOIN b.reviews r WHERE r.rating >= :minVal")
	List<Long> getIdsWithReviewsOfRatingGTE(@Param("minVal") Integer minVal);
	
	@Query("SELECT b.id FROM PlatformContentReviewBinder b JOIN b.reviews r WHERE r.likeDislikeScore >= 1")
	List<Long> getIdsWithReviewsOfPositiveValue();
}
