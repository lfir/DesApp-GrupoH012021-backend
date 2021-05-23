package ar.edu.unq.desapp.grupoh.model.AppContent;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
@DiscriminatorValue("series")
public class Series extends PlatformContent {
     @OneToMany
     private List<Episode> episodes;

     public Series(
         String titleId, TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate,
         Integer runtimeMinutes, List<Genre> genres, Crew crew, List<Principal> principals, List<Episode> episodes
     ) {
         super(titleId, titleInformation, isAdult, titleDate, runtimeMinutes, genres, crew, principals);
         this.episodes = episodes;
     }
}
