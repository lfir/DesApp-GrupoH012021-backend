package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TitleDate {
    @Id
    @GeneratedValue
    Long Id;
    LocalDate startYear;
    LocalDate endYear;

    public TitleDate (LocalDate startYear, LocalDate endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
    }
}
