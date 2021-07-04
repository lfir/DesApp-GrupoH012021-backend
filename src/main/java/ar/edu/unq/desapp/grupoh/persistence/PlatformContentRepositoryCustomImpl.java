package ar.edu.unq.desapp.grupoh.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.desapp.grupoh.model.AppContent.Movie;
import ar.edu.unq.desapp.grupoh.model.AppContent.Series;

public class PlatformContentRepositoryCustomImpl implements PlatformContentRepositoryCustom {
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	private PlatformContentReviewBinderRepository binderRepository;
	
	@Override
	public List<PlatformContent> findByAndPageResults(
		Integer pageNumber, Integer pageSize, Integer minReviewRating, Boolean positiveValueReviews,
		List<String> genreNames, List<String> actorNames, String decade
	) {
		// Filtering logic
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<PlatformContent> cq = cb.createQuery(PlatformContent.class);
        Root<PlatformContent> contentRoot = cq.from(PlatformContent.class);
        contentRoot.join("binder");
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        predicates.add(cb.or(cb.equal(contentRoot.type(), cb.literal(Movie.class)), cb.equal(contentRoot.type(), cb.literal(Series.class))));
        Path<Long> rowBinderId = contentRoot.get("binder").get("id");
        if (Objects.nonNull(minReviewRating)) {
        	List<Long> minRatingBinderIds = this.binderRepository.getIdsWithReviewsOfRatingGTE(minReviewRating);
        	predicates.add(rowBinderId.in(minRatingBinderIds));
        }
        if (Objects.nonNull(positiveValueReviews) && positiveValueReviews) {
        	List<Long> positiveValueBinderIds = this.binderRepository.getIdsWithReviewsOfPositiveValue();
        	predicates.add(rowBinderId.in(positiveValueBinderIds));
        }
        if (Objects.nonNull(genreNames) && genreNames.size() > 0) {
        	predicates.add(contentRoot.join("genres").get("name").in(genreNames));
        }
        if (Objects.nonNull(actorNames) && actorNames.size() > 0) {
        	predicates.add(contentRoot.join("principals").get("name").in(actorNames));
        }
        if (Objects.nonNull(decade)) {
        	Path<LocalDate> rowStartYear = contentRoot.get("titleDate").get("startYear");
        	LocalDate startDate = LocalDate.parse(decade + "-01-01");
        	LocalDate endDate = LocalDate.parse(String.valueOf(Integer.valueOf(decade) + 9) + "-01-01");
        	predicates.add(cb.between(rowStartYear, startDate, endDate));
        }
        
        Predicate[] predArray = new Predicate[predicates.size()];
        predicates.toArray(predArray);
        cq.where(predArray);
        cq.distinct(true);
		
        // Pagination logic. Argument pageNumber starts at 1
        TypedQuery<PlatformContent> query = this.entityManager.createQuery(cq);
        query.setFirstResult((pageNumber - 1) * pageSize); 
        query.setMaxResults(pageSize);

        return query.getResultList();
	}
}
