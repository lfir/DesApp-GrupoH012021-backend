package ar.edu.unq.desapp.grupoh.model.AppContent;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie extends Title {
    public Movie(TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes, List<String> genres, Crew crew, List<Principals> principals) {
        super(titleInformation, isAdult, titleDate, runtimeMinutes, genres, crew, principals);
    }
}
