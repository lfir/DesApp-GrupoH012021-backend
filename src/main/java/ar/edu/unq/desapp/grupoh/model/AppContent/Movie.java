package ar.edu.unq.desapp.grupoh.model.AppContent;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.*;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie extends PlatformContent {
    public Movie(String titleId, TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes, List<Genre> genres, Crew crew, List<Principal> principals) {
        super(titleId, titleInformation, isAdult, titleDate, runtimeMinutes, genres, crew, principals);
    }
}
