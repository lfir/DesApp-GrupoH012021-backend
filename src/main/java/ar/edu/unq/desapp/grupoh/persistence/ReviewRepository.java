package ar.edu.unq.desapp.grupoh.persistence;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoh.model.Review.Review;

public class ReviewRepository {
	private List<Review> reviews = new ArrayList<Review>();
	
	public void add(Review review) {
		this.reviews.add(review);
	}
}
