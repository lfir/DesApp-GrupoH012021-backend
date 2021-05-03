package ar.edu.unq.desapp.grupoh.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoh.model.PlatformContentReviewBinder;
import ar.edu.unq.desapp.grupoh.model.Review.FreeReview;
import ar.edu.unq.desapp.grupoh.model.Review.PremiumReview;
import ar.edu.unq.desapp.grupoh.model.Review.Review;
import ar.edu.unq.desapp.grupoh.persistence.PlatformContentReviewBinderRepository;
import ar.edu.unq.desapp.grupoh.persistence.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private PlatformContentReviewBinderRepository binderRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	private Review review;
	
	public void add(ReviewRequestBody requestBody) {
		if (requestBody.getCountry() == null) {
			this.review = new PremiumReview(
				requestBody.getDescription(), requestBody.getFullDescription(), requestBody.getRating(), 
				requestBody.getDate(), requestBody.getOriginPlatformName(), requestBody.getPlatformUserId(), 
				requestBody.getLanguage(), 0, ""
			);
		} else {
			this.review = new FreeReview(
				requestBody.getDescription(), requestBody.getFullDescription(), requestBody.getRating(), 
				requestBody.getSpoilerAlert(), requestBody.getDate(), requestBody.getOriginPlatformName(),
				requestBody.getPlatformUserId(), requestBody.getNickname(), requestBody.getLanguage(),
				requestBody.getCountry(), 0, ""
			);
		}
		
		PlatformContentReviewBinder binder = this.binderRepository.findByContentImdbId(requestBody.getContentImdbId());
		if (binder.getReviews() == null) {
			binder.setReviews(Arrays.asList(this.review));
		} else {
			binder.getReviews().add(this.review);
		}
		this.binderRepository.save(binder);
	}

	public void updateLikeDislikeScore(Long id, String requestBody) {
		Integer value = 1;
		Boolean isDislike = requestBody.contains("dislike");
		if (isDislike) {
			value = -1;
		}
		
		Optional<Review> maybeReview = this.reviewRepository.findById(id);
		Review review = maybeReview.get();
		review.updateLikeDislikeScore(value);
		this.reviewRepository.save(review);
	}

	public List<Review> get(String contentImdbId) {
		PlatformContentReviewBinder binder = this.binderRepository.findByContentImdbId(contentImdbId);
		return binder.getReviews();
	}
}
