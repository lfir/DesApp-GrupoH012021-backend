package ar.edu.unq.desapp.grupoh.model.Review;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FreeReview extends Review {
	
	private Boolean spoilerAlert;
	private String nickname;
	private String country;

	public FreeReview(
		String description, String fullDescription, Integer rating, Boolean spoilerAlert, LocalDate date,
		ClientPlatform originPlatform, String platformUserId, String nickname, String language, String country,
		Integer score, List<String> reports
	) {
		super(description, fullDescription, rating, date, originPlatform, platformUserId, language, score, reports);
		this.nickname = nickname;
		this.spoilerAlert = spoilerAlert;
		this.country = country;
	}
}
