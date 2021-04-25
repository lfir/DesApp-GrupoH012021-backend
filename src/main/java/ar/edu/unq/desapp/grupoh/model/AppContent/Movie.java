package ar.edu.unq.desapp.grupoh.model.AppContent;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.*;

import java.util.ArrayList;


public class Movie extends Title {
    public Movie(TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes, ArrayList<String> genres, Crew crew, ArrayList<Principals> principals) {
        super(titleInformation, isAdult, titleDate, runtimeMinutes, genres, crew, principals);
    }
}
