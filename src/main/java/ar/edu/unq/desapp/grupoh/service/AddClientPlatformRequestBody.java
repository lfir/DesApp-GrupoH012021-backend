package ar.edu.unq.desapp.grupoh.service;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = AddClientPlatformRequestBody.Builder.class)
@Getter
public class AddClientPlatformRequestBody {
	@NonNull
	private String username;
	@NonNull
	private String password;
	@NonNull
	private String platformName;
	
	@JsonPOJOBuilder(withPrefix = "")
    public static class Builder {}
}
