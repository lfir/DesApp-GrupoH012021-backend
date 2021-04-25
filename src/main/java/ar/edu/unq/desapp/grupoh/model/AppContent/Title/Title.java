package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import ar.edu.unq.desapp.grupoh.model.AppContent.PlatformContent;

import java.util.ArrayList;

public abstract class Title extends PlatformContent {
    TitleInformation titleInformation;
    Boolean isAdult;
    TitleDate titleDate;
    Integer runtimeMinutes ;
    ArrayList<String> genres;
    Crew crew;
    ArrayList<Principals> principals;

    public Title (TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes ,ArrayList<String> genres, Crew crew, ArrayList<Principals> principals) {
        this.titleInformation = titleInformation;
        this.isAdult = isAdult;
        this.titleDate = titleDate;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
        this.crew = crew;
        this.principals = principals;
    }
}
