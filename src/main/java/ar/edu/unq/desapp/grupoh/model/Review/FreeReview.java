package ar.edu.unq.desapp.grupoh.model.Review;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import ar.edu.unq.desapp.grupoh.model.UserReport;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("free")
public class FreeReview extends Review {
	private Boolean spoilerAlert;
	private String nickname;
	private String country;
	@OneToMany(cascade=CascadeType.ALL)
	private List<UserReport> userReports;

	public FreeReview(
		String description, String fullDescription, Integer rating, Boolean spoilerAlert, LocalDate date,
		String originPlatform, String platformUserId, String nickname, String language, String country,
		Integer score, List<UserReport> reports
	) {
		super(description, fullDescription, rating, date, originPlatform, platformUserId, language, score);
		this.nickname = nickname;
		this.spoilerAlert = spoilerAlert;
		this.country = country;
		this.userReports = reports;
	}
}
