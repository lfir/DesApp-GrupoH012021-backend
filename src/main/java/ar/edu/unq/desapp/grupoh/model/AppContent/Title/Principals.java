package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Principals {
    String category;
    String job;
    String characters;

    public Principals (String category, String job, String characters) {
        this.category = category;
        this.job = job;
        this.characters = characters;
    }
}
