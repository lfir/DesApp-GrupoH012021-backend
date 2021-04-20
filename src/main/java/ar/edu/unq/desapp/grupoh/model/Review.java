package ar.edu.unq.desapp.grupoh.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Review {
	String description;
	String fullDescription;
	Integer rating;
	LocalDate date;
	ClientPlatform originPlatform;
	String platformUserId;
	String language;
	Integer likeDislikeScore;
	List<String> userReports;
}
