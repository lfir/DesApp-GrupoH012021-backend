package ar.edu.unq.desapp.grupoh.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.TitleDate;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.TitleInformation;
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
	
	@Test
	void whenGetBasicContentInfoIsCalledCorrectPlatformContentDataIsReturned() {
		PlatformContent platformContent = mock(PlatformContent.class);
		String testId = "xSj9H";
		given(platformContent.getTitleId()).willReturn(testId);
		String testTitle = "testTitle";
		TitleInformation titleInfo = mock(TitleInformation.class);
		given(titleInfo.getOriginalTitle()).willReturn(testTitle);
		given(platformContent.getTitleInformation()).willReturn(titleInfo);
		TitleDate titleDate = mock(TitleDate.class);
		LocalDate date = LocalDate.parse("2000-01-01");
		given(titleDate.getStartYear()).willReturn(date);
		given(platformContent.getTitleDate()).willReturn(titleDate);
		given(platformContent.getRuntimeMinutes()).willReturn(10);
		given(platformContent.getIsAdult()).willReturn(false);
		List<Review> reviews = new ArrayList<>();
		PlatformContentReviewBinder platformContentReviewBinder = new PlatformContentReviewBinder(
			platformContent, reviews
		);
		
		List<String> basicInfo = platformContentReviewBinder.getPlatformContentBasicInfo();
		
		assertEquals(testId, basicInfo.get(0));
		assertEquals(testTitle, basicInfo.get(1));
		assertEquals("2000", basicInfo.get(2));
		assertEquals("10", basicInfo.get(3));
		assertEquals(String.valueOf(false), basicInfo.get(4));
	}
}
