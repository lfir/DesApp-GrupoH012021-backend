package ar.edu.unq.desapp.grupoh.model;

import java.util.List;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.model.Review.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatformContentReviewBinder {
	private PlatformContent platformContent;
	private List<Review> reviews;

	public String getPlatformContentImdbId() {
		return this.platformContent.getTitleId();
	}
}
