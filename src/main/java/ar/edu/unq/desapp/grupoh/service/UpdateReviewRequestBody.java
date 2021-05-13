package ar.edu.unq.desapp.grupoh.service;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder(builderClassName = "Builder")
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
