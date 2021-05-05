package ar.edu.unq.desapp.grupoh.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoh.model.Review.Review;

public class PlatformContentReviewBinderTest {
	@Test
	void whenValidDataThenPlatformContentReviewBinderWithCorrectFieldsIsCreated() {
		PlatformContent platformContent = mock(PlatformContent.class);
		Review review = mock(Review.class);
		List<Review> reviews = Arrays.asList(review);
		
		PlatformContentReviewBinder platformContentReviewBinder = new PlatformContentReviewBinder();
		platformContentReviewBinder.setId(Long.valueOf("2"));
		platformContentReviewBinder.setPlatformContent(platformContent);
		platformContentReviewBinder.setReviews(reviews);
		
		assertTrue(Long.class.isInstance(platformContentReviewBinder.getId()));
		assertTrue(PlatformContent.class.isInstance(platformContentReviewBinder.getPlatformContent()));
		assertTrue(Review.class.isInstance(platformContentReviewBinder.getReviews().get(0)));
	}
	
	@Test
	void whenGetPlatformContentImdbIdIsCalledItReturnsTheImdbIdOfTheTitle() {
		String testId = "xSj9H";
		PlatformContent platformContent = mock(PlatformContent.class);
		given(platformContent.getTitleId()).willReturn(testId);
		Review review = mock(Review.class);
		List<Review> reviews = Arrays.asList(review);
		
		PlatformContentReviewBinder platformContentReviewBinder = new PlatformContentReviewBinder(
			platformContent, reviews
		);
		
		assertEquals(testId, platformContentReviewBinder.getPlatformContentImdbId());
	}
}
