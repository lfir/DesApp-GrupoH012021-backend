package ar.edu.unq.desapp.grupoh.model.AppContent;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.Crew;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.Genre;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.Principal;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.TitleDate;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.TitleInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("movie")
public class Movie extends PlatformContent {
    public Movie(String titleId, TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes, List<Genre> genres, Crew crew, List<Principal> principals) {
        super(titleId, titleInformation, isAdult, titleDate, runtimeMinutes, genres, crew, principals);
    }
}
