package ar.edu.unq.desapp.grupoh.model.Review;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@DiscriminatorValue("premium")
public class PremiumReview extends Review {

	public PremiumReview(
			String description, String fullDescription, Integer rating, LocalDate date,
			String originPlatform, String platformUserId, String language,
			Integer score, String reports
		) {
		super(description, fullDescription, rating, date, originPlatform, platformUserId, language, score, reports);
	}
}
