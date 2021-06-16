package ar.edu.unq.desapp.grupoh.service;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = LogInRequestBody.Builder.class)
@Getter
public class LogInRequestBody {
	@NonNull
	private String username;
	@NonNull
	private String password;
	
	@JsonPOJOBuilder(withPrefix = "")
    public static class Builder {}
}
