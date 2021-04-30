package ar.edu.unq.desapp.grupoh.model.Review;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Review {
	@Id
    @GeneratedValue
	private Long id;
	private String description;
	private String fullDescription;
	private Integer rating;
	private LocalDate date;
	private String originPlatformName;
	private String platformUserId;
	private String language;
	private Integer likeDislikeScore;
	private String userReports;
	
	public Review(String description, String fullDescription, Integer rating, LocalDate date, String originPlatformName,
			String platformUserId, String language, Integer likeDislikeScore, String userReports) {
		this.description = description;
		this.fullDescription = fullDescription;
		this.rating = rating;
		this.date = date;
		this.originPlatformName = originPlatformName;
		this.platformUserId = platformUserId;
		this.language = language;
		this.likeDislikeScore = likeDislikeScore;
		this.userReports = userReports;
	}
	
	public void updateLikeDislikeScore(Integer value) {
		this.setLikeDislikeScore(this.getLikeDislikeScore() + value);
	}
}
