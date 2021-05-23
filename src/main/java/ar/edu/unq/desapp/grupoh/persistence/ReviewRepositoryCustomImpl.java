package ar.edu.unq.desapp.grupoh.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ar.edu.unq.desapp.grupoh.model.Review.FreeReview;
import ar.edu.unq.desapp.grupoh.model.Review.PremiumReview;
import ar.edu.unq.desapp.grupoh.model.Review.Review;

public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Review> findBySortAndPageResults(
		Integer pageNumber, Integer pageSize, String reviewType, String originPlatformName, Boolean spoilerAlert,
		String language, String country, Boolean ratingAscending, Boolean ratingDescending, Boolean dateAscending,
		Boolean dateDescending, Long binderId
	) {
		// Filtering logic
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Review> cq = cb.createQuery(Review.class);
        Root<Review> reviewRoot = cq.from(Review.class);
        reviewRoot.join("binder");
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        Predicate idPredicate = cb.equal(reviewRoot.get("binder").get("id"), binderId);
        predicates.add(idPredicate);
        if ("free".equals(reviewType)) {
        	predicates.add(cb.equal(reviewRoot.type(), cb.literal(FreeReview.class)));
        }
        if ("premium".equals(reviewType)) {
        	predicates.add(cb.equal(reviewRoot.type(), cb.literal(PremiumReview.class)));
        }
        if (Objects.nonNull(originPlatformName)) {
        	predicates.add(cb.equal(reviewRoot.get("originPlatformName"), originPlatformName));
        }
        if (Objects.nonNull(spoilerAlert) && "free".equals(reviewType)) {
        	Root<FreeReview> frsa = cb.treat(reviewRoot, FreeReview.class);
        	predicates.add(cb.equal(frsa.get("spoilerAlert"), spoilerAlert));
        }
        if (Objects.nonNull(language)) {
        	predicates.add(cb.equal(reviewRoot.get("language"), language));
        }
        if (Objects.nonNull(country) && "free".equals(reviewType)) {
        	Root<FreeReview> frco = cb.treat(reviewRoot, FreeReview.class);
        	predicates.add(cb.equal(frco.get("country"), country));
        }
        
        Predicate[] predArray = new Predicate[predicates.size()];
        predicates.toArray(predArray);
        cq.where(predArray);
        
        // Sorting logic
        List<Order> orders = new ArrayList<Order>();
        if (Objects.nonNull(ratingDescending) && ratingDescending) {
        	orders.add(cb.desc(reviewRoot.get("rating")));
        }
        if (Objects.nonNull(ratingAscending) && ratingAscending) {
    		orders.add(cb.asc(reviewRoot.get("rating")));
    	}
    	if (Objects.nonNull(dateDescending) && dateDescending) {
    		orders.add(cb.desc(reviewRoot.get("date")));
    	} 
    	if (Objects.nonNull(dateAscending) && dateAscending) {
    		orders.add(cb.asc(reviewRoot.get("date")));
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
