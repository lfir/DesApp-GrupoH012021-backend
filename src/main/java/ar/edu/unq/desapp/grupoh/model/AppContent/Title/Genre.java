package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Genre {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String production;

    public Genre (String name, String production) {
        this.name = name;
        this.production = production;
    }
}
