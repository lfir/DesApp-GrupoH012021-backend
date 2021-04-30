package ar.edu.unq.desapp.grupoh.service;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import lombok.Getter;

@Getter
public class AddReviewRequestBody {
	private String description;
	private String fullDescription;
	private Integer rating;
	private Boolean spoilerAlert;
	private LocalDate date;
	private ClientPlatform originPlatform;
	private String platformUserId;
	private String nickname;
	private String language;
	private String country;
	private Integer likeDislikeScore;
	private List<String> userReports;
	private String contentId;
}
