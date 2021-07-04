package ar.edu.unq.desapp.grupoh.persistence;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;

import java.util.List;

public interface PlatformContentRepositoryCustom {
	List<PlatformContent> findByAndPageResults(
		Integer pageNumber, Integer pageSize, Integer minReviewRating, Boolean positiveValueReviews,
		List<String> genreNames, List<String> actorNames, String decade
	);
}
