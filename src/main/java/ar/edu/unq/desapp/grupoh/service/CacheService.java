package ar.edu.unq.desapp.grupoh.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoh.model.PlatformContentReviewBinder;
import ar.edu.unq.desapp.grupoh.persistence.CachedDataRepository;
import ar.edu.unq.desapp.grupoh.persistence.PlatformContentReviewBinderRepository;

@Service
public class CacheService {
	@Autowired
	private PlatformContentReviewBinderRepository binderRepository;
	@Autowired
	private CachedDataRepository dataRepository;
	
	public void saveSummaryData() {
		List<PlatformContentReviewBinder> binders = this.binderRepository.findAll(); 
		for (PlatformContentReviewBinder binder : binders) {
			Long binderId = binder.getId();
			// Get aggregate data directly from the database
			Integer reviews = this.binderRepository.getNumberOfReviews(binderId);
			BigDecimal averageRating = this.binderRepository.getAverageRating(binderId);
			String formattedRating = "";
			if (!Objects.isNull(averageRating)) {
				formattedRating = averageRating.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
			}
			
			List<String> contentInfo = binder.getPlatformContentBasicInfo();
			contentInfo.add(formattedRating);
			contentInfo.add(reviews.toString());
			
			this.dataRepository.save(contentInfo.remove(0), String.join(",", contentInfo));
		}
	}
	
	public Map<String, String> getSummaryData(String contentImdbId) {
		String[] summaryData = this.dataRepository.findById(contentImdbId).split(",");
		Map<String, String> res = new HashMap<>();
		res.put("originalTitle", summaryData[0]);
		res.put("startYear", summaryData[1]);
		res.put("runtimeMinutes", summaryData[2]);
		res.put("isAdult", summaryData[3]);
		res.put("averageRating", summaryData[4]);
		res.put("reviews", summaryData[5]);
		
		return res;
	}
}
