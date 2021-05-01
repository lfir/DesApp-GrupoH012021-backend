package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class Genre {
    String name;
    String production;

    public Genre (String name, String production) {
        this.name = name;
        this.production = production;
    }
}
