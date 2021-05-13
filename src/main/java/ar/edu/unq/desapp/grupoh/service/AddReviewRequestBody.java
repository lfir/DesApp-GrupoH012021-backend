package ar.edu.unq.desapp.grupoh.service;

import java.time.LocalDate;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = AddReviewRequestBody.Builder.class)
@Getter
public class AddReviewRequestBody {
	@JsonPOJOBuilder(withPrefix = "")
    public static class Builder {}
	@NonNull
	private String description;
	@NonNull
	private String fullDescription;
	@NonNull
	private Integer rating;
	private Boolean spoilerAlert;
	@NonNull
	private LocalDate date;
	@NonNull
	private String originPlatformName;
	@NonNull
	private String platformUserId;
	private String nickname;
	@NonNull
	private String language;
	private String country;
	@NonNull
	private String contentImdbId;
}
