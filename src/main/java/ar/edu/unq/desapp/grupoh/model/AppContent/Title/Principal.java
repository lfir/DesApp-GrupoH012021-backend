package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Principal {
    String category;
    String job;
    String characters;

    public Principal(String category, String job, String characters) {
        this.category = category;
        this.job = job;
        this.characters = characters;
    }
}
