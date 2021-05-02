package ar.edu.unq.desapp.grupoh.model.AppContent;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.*;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Series extends PlatformContent {
     @OneToMany
     List<Episode> episodes;

     public Series(String titleId, TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes, List<Genre> genres, Crew crew, List<Principal> principals, List<Episode> episodes) {
          super(titleId, titleInformation, isAdult, titleDate, runtimeMinutes, genres, crew, principals);
          this.episodes = episodes;
     }
}
