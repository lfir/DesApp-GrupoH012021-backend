package ar.edu.unq.desapp.grupoh.persistence;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unq.desapp.grupoh.model.PlatformContentReviewBinder;

public interface PlatformContentReviewBinderRepository extends JpaRepository<PlatformContentReviewBinder, Long> {
	@Query("SELECT b FROM PlatformContentReviewBinder b WHERE b.platformContent.titleId = :titleId")
	PlatformContentReviewBinder findByContentImdbId(String titleId);
	
	@Query("SELECT b.id FROM PlatformContentReviewBinder b JOIN b.reviews r WHERE r.rating >= :minVal")
	List<Long> getIdsWithReviewsOfRatingGTE(Integer minVal);
	
	@Query("SELECT b.id FROM PlatformContentReviewBinder b JOIN b.reviews r WHERE r.likeDislikeScore >= 1")
	List<Long> getIdsWithReviewsOfPositiveValue();

	@Query("SELECT count(b.id) FROM PlatformContentReviewBinder b JOIN b.reviews WHERE b.id = :binderId")
	Integer getNumberOfReviews(Long binderId);

	@Query("SELECT avg(r.rating) FROM PlatformContentReviewBinder b JOIN b.reviews r WHERE b.id = :binderId")
	BigDecimal getAverageRating(Long binderId);
}
