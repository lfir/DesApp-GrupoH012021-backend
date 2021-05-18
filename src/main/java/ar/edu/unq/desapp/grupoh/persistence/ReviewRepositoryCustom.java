package ar.edu.unq.desapp.grupoh.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unq.desapp.grupoh.model.Review.Review;

public interface ReviewRepositoryCustom {
	List<Review> findBySortAndPageResults(
		Integer pageNumber, Integer pageSize, String reviewType, String originPlatformName, Boolean spoilerAlert,
		String language, String country, Boolean ratingAscending, Boolean ratingDescending, Boolean dateAscending,
		Boolean dateDescending, Long binderId
	);
}
