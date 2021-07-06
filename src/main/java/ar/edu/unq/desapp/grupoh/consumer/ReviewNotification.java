package ar.edu.unq.desapp.grupoh.consumer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReviewNotification {
    private String description;
    private String fullDescription;
    private Integer rating;
    private LocalDate date;
    private String originPlatformName;
    private String platformUserId;
    private String language;
    private Integer likeDislikeScore;
    private String titleId;

    public ReviewNotification (String description, String fullDescription, Integer rating, LocalDate date, String originPlatformName, String platformUserId, String language, Integer likeDislikeScore, String titleId) {
        this.description = description;
        this.fullDescription = fullDescription;
        this.rating = rating;
        this.date = date;
        this.originPlatformName = originPlatformName;
        this.platformUserId = platformUserId;
        this.language = language;
        this.likeDislikeScore = likeDislikeScore;
        this.titleId = titleId;
    }
}
