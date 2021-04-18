package ar.edu.unq.desapp.grupoh.model;

import java.time.LocalDate;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PremiumReview extends Review {

	public PremiumReview(
			String description, String fullDescription, Integer rating, LocalDate date,
			ClientPlatform originPlatform, String platformUserId, String language
		) {
		super(description, fullDescription, rating, date, originPlatform, platformUserId, language);
	}
}
