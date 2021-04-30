package ar.edu.unq.desapp.grupoh.service;

import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoh.model.Review.FreeReview;
import ar.edu.unq.desapp.grupoh.model.Review.PremiumReview;
import ar.edu.unq.desapp.grupoh.model.Review.Review;
import ar.edu.unq.desapp.grupoh.persistence.ReviewRepository;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository = new ReviewRepository();
	private Review review;
	private Long reviewId = Long.valueOf("0");
	
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
		this.reviewId++;
		this.reviewRepository.add(review);
	}

	public void updateLikeDislikeScore(Long id, String requestBody) {
		Integer value = 1;
		Boolean isDislike = requestBody.contains("dislike");
		if (isDislike) {
			value = -1;
		}
		this.reviewRepository.updateLikeDislikeScore(id, value);
	}
}
