package ar.edu.unq.desapp.grupoh.model;

import java.util.List;
import java.time.LocalDate;

public abstract class Title extends PlatformContent {
    String titleType;
    String primaryTitle;
    String originalTitle;
    Boolean isAdult;
    LocalDate startYear;
    LocalDate endYear;
    Integer runtimeMinutes ;
    List<String> genres;
}
