package ar.edu.unq.desapp.grupoh.model;

import java.time.LocalDate;
import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PremiumReview extends Review {

	public PremiumReview(
			String description, String fullDescription, Integer rating, LocalDate date,
			ClientPlatform originPlatform, String platformUserId, String language,
			Integer score, List<String> reports
		) {
		super(description, fullDescription, rating, date, originPlatform, platformUserId, language, score, reports);
	}
}
