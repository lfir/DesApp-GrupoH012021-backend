package ar.edu.unq.desapp.grupoh.webservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
}
