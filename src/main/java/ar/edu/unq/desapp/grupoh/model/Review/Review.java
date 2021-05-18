package ar.edu.unq.desapp.grupoh.model.Review;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.edu.unq.desapp.grupoh.model.PlatformContentReviewBinder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "review_type")
public abstract class Review {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String fullDescription;
	private Integer rating;
	private LocalDate date;
	private String originPlatformName;
	private String platformUserId;
	private String language;
	private Integer likeDislikeScore;
	@JsonIgnore
	@ManyToOne
	private PlatformContentReviewBinder binder;
	
	public Review(String description, String fullDescription, Integer rating, LocalDate date, String originPlatformName,
			String platformUserId, String language, Integer likeDislikeScore) {
		this.description = description;
		this.fullDescription = fullDescription;
		this.rating = rating;
		this.date = date;
		this.originPlatformName = originPlatformName;
		this.platformUserId = platformUserId;
		this.language = language;
		this.likeDislikeScore = likeDislikeScore;
	}
	
	public void updateLikeDislikeScore(Integer value) {
		this.setLikeDislikeScore(this.getLikeDislikeScore() + value);
	}
}
