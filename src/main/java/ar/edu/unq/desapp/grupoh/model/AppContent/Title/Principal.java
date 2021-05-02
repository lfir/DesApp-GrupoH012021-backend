package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Principal {
    @Id
    @GeneratedValue
    Long id;
    String category;
    String job;
    String characters;

    public Principal(String category, String job, String characters) {
        this.category = category;
        this.job = job;
        this.characters = characters;
    }
}
