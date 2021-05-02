package ar.edu.unq.desapp.grupoh.model.AppContent;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorColumn(name = "episode")
public class Episode extends PlatformContent {
    Integer seasonNumber;
    Integer episodeNumber;

    public Episode (Integer seasonNumber, Integer episodeNumber) {
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }
}
