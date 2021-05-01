package ar.edu.unq.desapp.grupoh.model.AppContent;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Episode extends PlatformContent {
    Integer seasonNumber;
    Integer episodeNumber;

    public Episode (Integer seasonNumber, Integer episodeNumber) {
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }
}
