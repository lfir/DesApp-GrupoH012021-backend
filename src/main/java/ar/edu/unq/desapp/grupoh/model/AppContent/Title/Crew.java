package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Crew {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private List<Principal> directors;
    @OneToMany
    private List<Principal> writers;

    public Crew(List<Principal> directors, List<Principal> writers) {
        this.directors = directors;
        this.writers = writers;
    }
}
