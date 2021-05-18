package ar.edu.unq.desapp.grupoh.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoh.dao.ReviewDAO;
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
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Review add(ReviewDAO requestBody) {
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
		
		// Filtering logic
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Review> cq = cb.createQuery(Review.class);
        Root<Review> review = cq.from(Review.class);
        review.join("binder");
        List<Predicate> predicates = new ArrayList<Predicate>();
        Predicate idPredicate = cb.equal(review.get("binder").get("id"), binderId);
        predicates.add(idPredicate);
        if ("free".equals(reviewType)) {
        	predicates.add(cb.equal(review.type(), cb.literal(FreeReview.class)));
        }
        if ("premium".equals(reviewType)) {
        	predicates.add(cb.equal(review.type(), cb.literal(PremiumReview.class)));
        }
        if (Objects.nonNull(originPlatformName)) {
        	predicates.add(cb.equal(review.get("originPlatformName"), originPlatformName));
        }
        if (Objects.nonNull(spoilerAlert) && "free".equals(reviewType)) {
        	Root<FreeReview> frsa = cb.treat(review, FreeReview.class);
        	predicates.add(cb.equal(frsa.get("spoilerAlert"), spoilerAlert));
        }
        if (Objects.nonNull(language)) {
        	predicates.add(cb.equal(review.get("language"), language));
        }
        if (Objects.nonNull(country) && "free".equals(reviewType)) {
        	Root<FreeReview> frco = cb.treat(review, FreeReview.class);
        	predicates.add(cb.equal(frco.get("country"), country));
        }
        Predicate[] predArray = new Predicate[predicates.size()];
        predicates.toArray(predArray);
        cq.where(predArray);
        
        // Sorting logic
        List<Order> orders = new ArrayList<Order>();
        if (Objects.nonNull(ratingDescending) && ratingDescending) {
        	orders.add(cb.desc(review.get("rating")));
        }
        if (Objects.nonNull(ratingAscending) && ratingAscending) {
    		orders.add(cb.asc(review.get("rating")));
    	}
    	if (Objects.nonNull(dateDescending) && dateDescending) {
    		orders.add(cb.desc(review.get("date")));
    	} 
    	if (Objects.nonNull(dateAscending) && dateAscending) {
    		orders.add(cb.asc(review.get("date")));
    	}
        Order[] ordArray = new Order[orders.size()];
        orders.toArray(ordArray);
        cq.orderBy(ordArray);
        
        // Pagination logic. Argument pageNumber starts at 1
        TypedQuery<Review> query = entityManager.createQuery(cq);
        query.setFirstResult((pageNumber - 1) * pageSize); 
        query.setMaxResults(pageSize);

        return query.getResultList();
	}
}
