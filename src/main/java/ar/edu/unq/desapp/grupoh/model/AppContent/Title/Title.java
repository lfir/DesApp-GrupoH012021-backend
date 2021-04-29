package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import ar.edu.unq.desapp.grupoh.model.AppContent.PlatformContent;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public abstract class Title extends PlatformContent {
    TitleInformation titleInformation;
    Boolean isAdult;
    TitleDate titleDate;
    Integer runtimeMinutes ;
    List<String> genres;
    Crew crew;
    List<Principals> principals;

    public Title (TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes ,List<String> genres, Crew crew, List<Principals> principals) {
        this.titleInformation = titleInformation;
        this.isAdult = isAdult;
        this.titleDate = titleDate;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
        this.crew = crew;
        this.principals = principals;
    }
}
