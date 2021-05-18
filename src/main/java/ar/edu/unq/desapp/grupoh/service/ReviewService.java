package ar.edu.unq.desapp.grupoh.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoh.dto.ReviewDTO;
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
	
	@Transactional
	public Review add(ReviewDTO requestBody) {
		if (Objects.isNull(requestBody.getCountry())) {
			this.review = new PremiumReview(
				requestBody.getDescription(), requestBody.getFullDescription(), requestBody.getRating(), 
				requestBody.getDate(), requestBody.getOriginPlatformName(), requestBody.getPlatformUserId(), 
				requestBody.getLanguage(), 0
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
		this.review.setBinder(binder);
		if (Objects.isNull(binder.getReviews())) {
			binder.setReviews(Arrays.asList(this.review));
		} else {
			binder.getReviews().add(this.review);
		}
		this.binderRepository.save(binder);
		return binder.getReviews().get(binder.getReviews().size() - 1);
	}

	@Transactional
	public Review update(Long id, UpdateReviewRequestBody requestBody) {
		Optional<Review> maybeReview = this.reviewRepository.findById(id);
		Review review = maybeReview.get();
		if ("likeDislikeScore".equals(requestBody.getAttribute())) {
			Integer value = 1;
			Boolean isDislike = "dislike".equals(requestBody.getValue());
			if (isDislike) {
				value = -1;
			}
			review.updateLikeDislikeScore(value);
		}
		if ("userReports".equals(requestBody.getAttribute())) {
			FreeReview freeReview = (FreeReview) review;
			freeReview.setUserReports(freeReview.getUserReports() + "|" + requestBody.getValue());
		}
		
		this.reviewRepository.save(review);
		return review;
	}

	public List<Review> get(
		String contentImdbId, Integer pageNumber, Integer pageSize, String reviewType, String originPlatformName,
		Boolean spoilerAlert, String language, String country, Boolean ratingAscending, Boolean ratingDescending, 
		Boolean dateAscending, Boolean dateDescending
	) {
		PlatformContentReviewBinder binder = this.binderRepository.findByContentImdbId(contentImdbId);
		Long binderId = binder.getId();
		
		return this.reviewRepository.findBySortAndPageResults(
			pageNumber, pageSize, reviewType, originPlatformName, spoilerAlert, language, country,
			ratingAscending, ratingDescending, dateAscending, dateDescending, binderId
		);
	}
}
