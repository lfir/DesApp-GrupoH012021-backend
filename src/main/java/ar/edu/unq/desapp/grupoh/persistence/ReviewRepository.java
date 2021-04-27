package ar.edu.unq.desapp.grupoh.persistence;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoh.model.Review.Review;
import lombok.Getter;

@Getter
public class ReviewRepository {
	private List<Review> reviews = new ArrayList<Review>();
	
	public void add(Review review) {
		this.reviews.add(review);
	}

	public void updateLikeDislikeScore(Long id, Integer value) {
		for (Review r: this.reviews ) {
			if (r.getId().equals(id)) {
				r.updateLikeDislikeScore(value);
			}
		}
	}
}
