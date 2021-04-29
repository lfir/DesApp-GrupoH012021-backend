package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TitleDate {
    LocalDate startYear;
    LocalDate endYear;

    public TitleDate (LocalDate startYear, LocalDate endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
    }
}
