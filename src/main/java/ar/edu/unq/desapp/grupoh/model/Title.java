package ar.edu.unq.desapp.grupoh.model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Title extends PlatformContent {
    String titleType;
    String primaryTitle;
    String originalTitle;
    Boolean isAdult;
    Date startYear;
    Date endYear;
    Integer runtimeMinutes ;
    ArrayList<String> genres;
}
