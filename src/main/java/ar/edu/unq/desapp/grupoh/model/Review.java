package ar.edu.unq.desapp.grupoh.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
abstract class Review {
	String description;
	String fullDescription;
	Integer rating;
	LocalDate date;
	ClientPlatform originPlatform;
	String platformUserId;
	String language;
}
