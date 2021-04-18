package ar.edu.unq.desapp.grupoh.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ReviewTest {
	private ClientPlatform clientPlatform = new ClientPlatform();
	
	@Test
	void whenValidDataThenFreeReviewWithCorrectFieldsIsCreated() {
		FreeReview freeReview = new FreeReview();
		freeReview.setCountry("USA");
		freeReview.setDate(LocalDate.now());
		freeReview.setDescription("Desc");
		freeReview.setFullDescription("FullDesc");
		freeReview.setLanguage("Russian");
		freeReview.setNickname("testNickname");
		freeReview.setOriginPlatform(this.clientPlatform);
		freeReview.setPlatformUserId("uid0");
		freeReview.setRating(2);
		freeReview.setSpoilerAlert(Boolean.TRUE);
		
		assertTrue(String.class.isInstance(freeReview.getCountry()));
		assertTrue(LocalDate.class.isInstance(freeReview.getDate()));
		assertTrue(String.class.isInstance(freeReview.getDescription()));
		assertTrue(String.class.isInstance(freeReview.getFullDescription()));
		assertTrue(String.class.isInstance(freeReview.getLanguage()));
		assertTrue(String.class.isInstance(freeReview.getNickname()));
		assertTrue(ClientPlatform.class.isInstance(freeReview.getOriginPlatform()));
		assertTrue(String.class.isInstance(freeReview.getPlatformUserId()));
		assertTrue(Integer.class.isInstance(freeReview.getRating()));
		assertTrue(Boolean.class.isInstance(freeReview.getSpoilerAlert()));
	}
	
	@Test
	void whenValidDataThenPremiumReviewWithCorrectFieldsIsCreated() {
		PremiumReview premiumReview = new PremiumReview();
		premiumReview.setDate(LocalDate.now());
		premiumReview.setDescription("Desc");
		premiumReview.setFullDescription("FullDesc");
		premiumReview.setLanguage("Russian");
		premiumReview.setOriginPlatform(this.clientPlatform);
		premiumReview.setPlatformUserId("uid0");
		premiumReview.setRating(2);
		
		PremiumReview premiumReview2 = new PremiumReview(
			"testPremiumReview", "testFullDescription", 1, LocalDate.now(),
			this.clientPlatform, "id0", "English"
		);
		
		assertTrue(LocalDate.class.isInstance(premiumReview.getDate()));
		assertTrue(String.class.isInstance(premiumReview.getDescription()));
		assertTrue(String.class.isInstance(premiumReview.getFullDescription()));
		assertTrue(String.class.isInstance(premiumReview.getLanguage()));
		assertTrue(ClientPlatform.class.isInstance(premiumReview.getOriginPlatform()));
		assertTrue(String.class.isInstance(premiumReview.getPlatformUserId()));
		assertTrue(Integer.class.isInstance(premiumReview.getRating()));
		assertTrue(PremiumReview.class.isInstance(premiumReview2));
	}

	@Test
	void freeReviewHasFieldsSpoilerAlertNicknameAndCountry() {
		Boolean spoilerAlert = Boolean.FALSE;
		String nickname = "testUser";
		String country = "Argentina";
		FreeReview freeReview = new FreeReview(
			"testFreeReview", "testFullDescription", 1, spoilerAlert, LocalDate.now(),
			this.clientPlatform, "id0", nickname, "English", country
		);
		
		assertEquals(spoilerAlert, freeReview.getSpoilerAlert());
		assertEquals(nickname, freeReview.getNickname());
		assertEquals(country, freeReview.getCountry());
	}
	
	@Test
	void premiumReviewDoesNotHaveFieldsSpoilerAlertNicknameAndCountry() {
		List<Boolean> res = new ArrayList<Boolean>();
		
		for (Field f: Review.class.getDeclaredFields()) {
			if (f.getName().equals("spoilerAlert") || f.getName().equals("nickname") ||
				f.getName().equals("country")) {
				res.add(Boolean.TRUE);
			}
		}
		
		assertEquals(0, res.size());
	}
}
