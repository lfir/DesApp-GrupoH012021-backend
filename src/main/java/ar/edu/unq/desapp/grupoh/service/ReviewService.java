package ar.edu.unq.desapp.grupoh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		/*if (requestBody.getCountry() == null) {
			this.review = new PremiumReview(
				this.reviewId,
				requestBody.getDescription(), requestBody.getFullDescription(), requestBody.getRating(), requestBody.getDate(),
				requestBody.getOriginPlatform(), requestBody.getPlatformUserId(), requestBody.getLanguage(),
				requestBody.getLikeDislikeScore(), requestBody.getUserReports()
			);
		} else {
			this.review = new FreeReview(
				this.reviewId,
				requestBody.getDescription(), requestBody.getFullDescription(), requestBody.getRating(), 
				requestBody.getSpoilerAlert(), requestBody.getDate(), requestBody.getOriginPlatform(),
				requestBody.getPlatformUserId(), requestBody.getNickname(), requestBody.getLanguage(),
				requestBody.getCountry(), requestBody.getLikeDislikeScore(), requestBody.getUserReports()	
			);
		}*/
		
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
}
