package ar.edu.unq.desapp.grupoh.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoh.service.ReviewRequestBody;
import ar.edu.unq.desapp.grupoh.service.ReviewService;

@RestController
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@CrossOrigin
    @PostMapping("/api/reviews")
    public ResponseEntity<String> createAndSaveNewReview(@RequestBody ReviewRequestBody requestBody) {
		this.reviewService.add(requestBody);
		return ResponseEntity.ok("Registered a new review.");
	}
	
	@CrossOrigin
	@PutMapping("/api/reviews/{id}")
	public ResponseEntity<String> updateReviewUserValue(@PathVariable(value = "id") Long id, @RequestBody String requestBody) {
		this.reviewService.updateLikeDislikeScore(id, requestBody);
		return ResponseEntity.ok("Updated like/dislike score of the review.");
	}
}
