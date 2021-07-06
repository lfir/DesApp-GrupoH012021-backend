package ar.edu.unq.desapp.grupoh.webservice;

import java.util.List;
import java.util.Map;

import ar.edu.unq.desapp.grupoh.dto.SubscriberDTO;
import ar.edu.unq.desapp.grupoh.exception.UnauthorizedException;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import ar.edu.unq.desapp.grupoh.service.ClientPlatformService;
import ar.edu.unq.desapp.grupoh.service.PlatformContentService;
import ar.edu.unq.desapp.grupoh.service.SubscribeRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.unq.desapp.grupoh.service.CacheService;

@RestController
public class PlatformContentController {
	@Autowired
	private PlatformContentService platformContentService;
	@Autowired
	private CacheService cacheService;
	private final String commonPath = "/api/platformcontents";

	@CrossOrigin
	@GetMapping(commonPath)
	public ResponseEntity<List<PlatformContent>> inverseSearch(
		@RequestParam(value = "pagenumber") Integer pageNumber,
		@RequestParam(value = "pagesize") Integer pageSize,
		@RequestParam(value = "minreviewrating", required = false) Integer minReviewRating,
		@RequestParam(value = "positivevaluereviews", required = false) Boolean positiveValueReviews,
		@RequestParam(value = "genrenames", required = false) List<String> genreNames,
		@RequestParam(value = "actornames", required = false) List<String> actorNames,
		@RequestParam(value = "decade", required = false) String decade,
		@RequestHeader(value = "Api-key") String apiKey
	) {
		return ResponseEntity.ok(
			this.platformContentService.get(
				pageNumber, pageSize, minReviewRating, positiveValueReviews, 
				genreNames, actorNames, decade
			)
		);
	}
	
	@CrossOrigin
	@GetMapping(commonPath + "/summary")
	public ResponseEntity<Map<String, String>> getSummaryInfo(
		@RequestParam(value = "contentimdbid") String contentImdbId,
		@RequestHeader(value = "Api-key") String apiKey
	) {
		return ResponseEntity.ok(
			this.cacheService.getSummaryData(contentImdbId)
		);
	}
}
