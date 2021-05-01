package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class PlatformContent {
    String titleId;
    TitleInformation titleInformation;
    Boolean isAdult;
    TitleDate titleDate;
    Integer runtimeMinutes ;
    List<Genre> genres;
    Crew crew;
    List<Principal> principals;

    public PlatformContent(String titleId, TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes , List<Genre> genres, Crew crew, List<Principal> principals) {
        this.titleId = titleId;
        this.titleInformation = titleInformation;
        this.isAdult = isAdult;
        this.titleDate = titleDate;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
        this.crew = crew;
        this.principals = principals;
    }
}
