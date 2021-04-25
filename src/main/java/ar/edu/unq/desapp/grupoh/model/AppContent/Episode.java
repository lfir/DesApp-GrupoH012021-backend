package ar.edu.unq.desapp.grupoh.model.AppContent;

public class Episode extends PlatformContent{
    Integer seasonNumber;
    Integer episodeNumber;

    public Episode (Integer seasonNumber, Integer episodeNumber) {
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }
}
