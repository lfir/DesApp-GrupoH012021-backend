package ar.edu.unq.desapp.grupoh.service;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class ReviewRequestBody {
	private String description;
	private String fullDescription;
	private Integer rating;
	private Boolean spoilerAlert;
	private LocalDate date;
	private String originPlatformName;
	private String platformUserId;
	private String nickname;
	private String language;
	private String country;
	private Integer likeDislikeScore;
	private String userReports;
	private String contentImdbId;
}
