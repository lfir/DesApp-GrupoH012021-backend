package ar.edu.unq.desapp.grupoh.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unq.desapp.grupoh.dto.SubscriberDTO;
import ar.edu.unq.desapp.grupoh.model.AppContent.Subscriber;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.persistence.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unq.desapp.grupoh.persistence.PlatformContentRepository;

import javax.transaction.Transactional;

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

	public Optional<PlatformContent> getByTitleId(String titleId) {
		return platformContentRepository.findByIdIMDB(titleId);
	}
}
