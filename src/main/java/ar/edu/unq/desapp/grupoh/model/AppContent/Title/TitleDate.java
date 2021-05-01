package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TitleDate {
    LocalDate startYear;
    LocalDate endYear;

    public TitleDate (LocalDate startYear, LocalDate endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
    }
}
