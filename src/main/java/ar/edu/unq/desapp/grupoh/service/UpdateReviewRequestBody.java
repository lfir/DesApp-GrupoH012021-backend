package ar.edu.unq.desapp.grupoh.service;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = UpdateReviewRequestBody.Builder.class)
@Getter
public class UpdateReviewRequestBody {
	@JsonPOJOBuilder(withPrefix = "")
    public static class Builder {}
	@NonNull
	private String attribute;
	@NonNull
	private String value;
}
