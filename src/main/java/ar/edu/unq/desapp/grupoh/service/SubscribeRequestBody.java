package ar.edu.unq.desapp.grupoh.service;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = SubscribeRequestBody.Builder.class)
@Getter
public class SubscribeRequestBody {
    @NonNull
    private String contentImdbId;
    @NonNull
    private String username;
    @NonNull
    private String url;

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {}
}