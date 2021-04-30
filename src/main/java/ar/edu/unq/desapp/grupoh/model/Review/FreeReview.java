package ar.edu.unq.desapp.grupoh.model.Review;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class FreeReview extends Review {
	private Boolean spoilerAlert;
	private String nickname;
	private String country;

	public FreeReview(
		String description, String fullDescription, Integer rating, Boolean spoilerAlert, LocalDate date,
		String originPlatform, String platformUserId, String nickname, String language, String country,
		Integer score, String reports
	) {
		super(description, fullDescription, rating, date, originPlatform, platformUserId, language, score, reports);
		this.nickname = nickname;
		this.spoilerAlert = spoilerAlert;
		this.country = country;
	}
}
