package ar.edu.unq.desapp.grupoh.model.Review;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PremiumReview extends Review {

	public PremiumReview(
			Long id, String description, String fullDescription, Integer rating, LocalDate date,
			ClientPlatform originPlatform, String platformUserId, String language,
			Integer score, List<String> reports
		) {
		super(id, description, fullDescription, rating, date, originPlatform, platformUserId, language, score, reports);
	}
}
