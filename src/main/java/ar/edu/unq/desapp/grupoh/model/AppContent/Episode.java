package ar.edu.unq.desapp.grupoh.model.AppContent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Episode extends PlatformContent{
    Integer seasonNumber;
    Integer episodeNumber;

    public Episode (Integer seasonNumber, Integer episodeNumber) {
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }
}
