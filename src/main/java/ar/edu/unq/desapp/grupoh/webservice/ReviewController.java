package ar.edu.unq.desapp.grupoh.webservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoh.service.ReviewRequestBody;
import ar.edu.unq.desapp.grupoh.service.ReviewService;

@RestController
public class ReviewController {
	private final ReviewService reviewService = new ReviewService();
	
	@CrossOrigin
    @PostMapping("/reviews")
    @ResponseBody
    public ResponseEntity createAndSaveNewReview(@RequestBody ReviewRequestBody requestBody) {
		this.reviewService.add(requestBody);
		return ResponseEntity.ok("Registered a new review.");
	}
	
	@CrossOrigin
	@PutMapping("/reviews/{id}")
	@ResponseBody
	public ResponseEntity updateReviewUserValue(@PathVariable(value = "id") Long id, @RequestBody String requestBody) {
		this.reviewService.updateLikeDislikeScore(id, requestBody);
		return ResponseEntity.ok("Updated like/dislike score of the review.");
	}
}
