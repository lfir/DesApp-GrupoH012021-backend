package ar.edu.unq.desapp.grupoh.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.service.PlatformContentService;

@RestController
public class PlatformContentController {
	@Autowired
	private PlatformContentService platformContentService;

	@CrossOrigin
	@GetMapping("/api/platformcontents")
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
}
