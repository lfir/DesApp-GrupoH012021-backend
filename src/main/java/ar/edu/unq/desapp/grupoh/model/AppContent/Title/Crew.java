package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Crew {
    List<String> directors;
    List<String> writers;

    public Crew (List<String> directors, List<String> writers) {
        this.directors = directors;
        this.writers = writers;
    }
}
