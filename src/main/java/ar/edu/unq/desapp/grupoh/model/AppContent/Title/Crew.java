package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import java.util.ArrayList;

public class Crew {
    ArrayList<String> directors;
    ArrayList<String> writers;

    public Crew (ArrayList<String> directors, ArrayList<String> writers) {
        this.directors = directors;
        this.writers = writers;
    }
}
