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

@Service
public class PlatformContentService {
	@Autowired
	private PlatformContentRepository platformContentRepository;
	@Autowired
	private SubscriberRepository subscriberRepository;

	public List<PlatformContent> get(
		Integer pageNumber, Integer pageSize, Integer minReviewRating, Boolean positiveValueReviews,
		List<String> genreNames, List<String> actorNames, String decade
	) {
		return this.platformContentRepository.findByAndPageResults(pageNumber, pageSize, minReviewRating, positiveValueReviews, genreNames, actorNames, decade);
	}

	public void setSubscriber(SubscriberDTO subscriberDTO) {
		Optional<PlatformContent> platformContentFromdb = platformContentRepository.findByIdIMDB(subscriberDTO.getContentImdbId());
		Subscriber subscriber = new Subscriber(subscriberDTO.contentImdbId, subscriberDTO.platform, subscriberDTO.url);
		subscriberRepository.save(subscriber);
		List<Subscriber> subscribers = platformContentFromdb.get().getSubscribers();
		subscribers.add(subscriber);
		platformContentFromdb.get().setSubscribers(subscribers);
		platformContentRepository.save(platformContentFromdb.get());

	}
}
