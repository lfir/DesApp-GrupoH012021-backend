package ar.edu.unq.desapp.grupoh.model.AppContent;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.*;

import java.util.ArrayList;

public class Serie extends Title {
     ArrayList<Episode> episodes;

     public Serie(TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes, ArrayList<String> genres, Crew crew, ArrayList<Principals> principals, ArrayList<Episode> episodes) {
          super(titleInformation, isAdult, titleDate, runtimeMinutes, genres, crew, principals);
          this.episodes = episodes;
     }
}
