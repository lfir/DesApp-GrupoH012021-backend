package ar.edu.unq.desapp.grupoh.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoh.model.Review.FreeReview;
import ar.edu.unq.desapp.grupoh.model.Review.PremiumReview;
import ar.edu.unq.desapp.grupoh.model.Review.Review;

public class ReviewTest {
	@Test
	void whenValidDataThenFreeReviewWithCorrectFieldsIsCreated() {
		FreeReview freeReview = new FreeReview();
		freeReview.setId(Long.valueOf("33"));
		freeReview.setCountry("USA");
		freeReview.setDate(LocalDate.now());
		freeReview.setDescription("Desc");
		freeReview.setFullDescription("FullDesc");
		freeReview.setLanguage("Russian");
		freeReview.setNickname("testNickname");
		freeReview.setOriginPlatformName("Netflix");
		freeReview.setPlatformUserId("uid0");
		freeReview.setRating(2);
		freeReview.setSpoilerAlert(Boolean.TRUE);
		freeReview.setLikeDislikeScore(2);
		freeReview.setUserReports("");
		
		assertTrue(Long.class.isInstance(freeReview.getId()));
		assertTrue(String.class.isInstance(freeReview.getCountry()));
		assertTrue(LocalDate.class.isInstance(freeReview.getDate()));
		assertTrue(String.class.isInstance(freeReview.getDescription()));
		assertTrue(String.class.isInstance(freeReview.getFullDescription()));
		assertTrue(String.class.isInstance(freeReview.getLanguage()));
		assertTrue(String.class.isInstance(freeReview.getNickname()));
		assertTrue(String.class.isInstance(freeReview.getOriginPlatformName()));
		assertTrue(String.class.isInstance(freeReview.getPlatformUserId()));
		assertTrue(Integer.class.isInstance(freeReview.getRating()));
		assertTrue(Boolean.class.isInstance(freeReview.getSpoilerAlert()));
		assertTrue(Integer.class.isInstance(freeReview.getLikeDislikeScore()));
		assertTrue(String.class.isInstance(freeReview.getUserReports()));
	}
	
	@Test
	void whenValidDataThenPremiumReviewWithCorrectFieldsIsCreated() {
		PremiumReview premiumReview = new PremiumReview();
		premiumReview.setId(Long.valueOf("33"));
		premiumReview.setDate(LocalDate.now());
		premiumReview.setDescription("Desc");
		premiumReview.setFullDescription("FullDesc");
		premiumReview.setLanguage("Russian");
		premiumReview.setOriginPlatformName("Netflix");
		premiumReview.setPlatformUserId("uid0");
		premiumReview.setRating(2);
		premiumReview.setLikeDislikeScore(5);
		
		PremiumReview premiumReview2 = new PremiumReview(
			"testPremiumReview", "testFullDescription", 1, LocalDate.now(),
			"Netflix", "id0", "English", 3
		);
		
		assertTrue(Long.class.isInstance(premiumReview.getId()));
		assertTrue(LocalDate.class.isInstance(premiumReview.getDate()));
		assertTrue(String.class.isInstance(premiumReview.getDescription()));
		assertTrue(String.class.isInstance(premiumReview.getFullDescription()));
		assertTrue(String.class.isInstance(premiumReview.getLanguage()));
		assertTrue(String.class.isInstance(premiumReview.getOriginPlatformName()));
		assertTrue(String.class.isInstance(premiumReview.getPlatformUserId()));
		assertTrue(Integer.class.isInstance(premiumReview.getRating()));
		assertTrue(Integer.class.isInstance(premiumReview.getLikeDislikeScore()));
		assertTrue(PremiumReview.class.isInstance(premiumReview2));
	}

	@Test
	void freeReviewHasFieldsSpoilerAlertNicknameAndCountryAndUserReports() {
		Boolean spoilerAlert = Boolean.FALSE;
		String nickname = "testUser";
		String country = "Argentina";
		String userReports = "testUserReport";
		FreeReview freeReview = new FreeReview(
			"testFreeReview", "testFullDescription", 1, spoilerAlert, LocalDate.now(),
			"Netflix", "id0", nickname, "English", country, 2, userReports
		);
		
		assertEquals(spoilerAlert, freeReview.getSpoilerAlert());
		assertEquals(nickname, freeReview.getNickname());
		assertEquals(country, freeReview.getCountry());
		assertEquals(userReports, freeReview.getUserReports());
	}
	
	@Test
	void premiumReviewDoesNotHaveFieldsSpoilerAlertNicknameAndCountryAndUserReports() {
		List<Boolean> res = new ArrayList<Boolean>();
		
		for (Field f: Review.class.getDeclaredFields()) {
			if (f.getName().equals("spoilerAlert") || f.getName().equals("nickname") ||
				f.getName().equals("country") || f.getName().equals("userReports")) {
				res.add(Boolean.TRUE);
			}
		}
		
		assertEquals(0, res.size());
	}
	
	@Test
	void whenMethodUpdateLikeDislikeScoreIsCalledWithValueSixThePreviousScoreIsIncreasedBySix() {
		PremiumReview review = new PremiumReview(
			"testPremiumReview", "testFullDescription", 1, LocalDate.now(),
			"Amazon", "id0", "English", 3
		);
		
		review.updateLikeDislikeScore(6);
		
		assertEquals(9, review.getLikeDislikeScore());
	}
}
