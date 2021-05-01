package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Crew {
    List<Principal> directors;
    List<Principal> writers;

    public Crew (List<Principal> directors, List<Principal> writers) {
        this.directors = directors;
        this.writers = writers;
    }
}
