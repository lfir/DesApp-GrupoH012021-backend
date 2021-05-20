package ar.edu.unq.desapp.grupoh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.persistence.PlatformContentRepository;

@Service
public class PlatformContentService {
	@Autowired
	private PlatformContentRepository platformContentRepository;

	public List<PlatformContent> get(
		Integer pageNumber, Integer pageSize, Integer minReviewRating, Boolean positiveValueReviews,
		List<String> genreNames, List<String> actorNames, String decade
	) {
		return this.platformContentRepository.findByAndPageResults(pageNumber, pageSize, minReviewRating, positiveValueReviews, genreNames, actorNames, decade);
	}
}
