package ar.edu.unq.desapp.grupoh.model.AppContent;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Series extends Title {
     List<Episode> episodes;

     public Series(TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes, List<String> genres, Crew crew, List<Principals> principals, List<Episode> episodes) {
          super(titleInformation, isAdult, titleDate, runtimeMinutes, genres, crew, principals);
          this.episodes = episodes;
     }
}
