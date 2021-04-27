package ar.edu.unq.desapp.grupoh.model.Review;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Review {
	private Long id;
	private String description;
	private String fullDescription;
	private Integer rating;
	private LocalDate date;
	private ClientPlatform originPlatform;
	private String platformUserId;
	private String language;
	private Integer likeDislikeScore;
	private List<String> userReports;
	
	public void updateLikeDislikeScore(Integer value) {
		this.setLikeDislikeScore(this.getLikeDislikeScore() + value);
	}
}
