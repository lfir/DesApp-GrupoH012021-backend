package ar.edu.unq.desapp.grupoh.PlataformContentTest;

import ar.edu.unq.desapp.grupoh.model.AppContent.Movie;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    void whenValidDataThenMovieWithCorrectDataIsCreated () {
        String titleId = "as2d2d";
        TitleInformation titleInformation = new TitleInformation("short", "The Sea", "Baignade en mer");
        TitleDate titleDate = new TitleDate(LocalDate.parse("1985-10-10"), null);
        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(new Genre("Historical", "Cine"));
        genres.add(new Genre("Short", "Cine"));
        Principal director = new Principal("Director", "Director of photography", "/N");
        Principal writer = new Principal("Writer", "Writer", "/N");
        ArrayList<Principal> directors = new ArrayList<>();
        directors.add(director);
        ArrayList<Principal> writers = new ArrayList<>();
        writers.add(writer);
        Crew crew = new Crew(directors, writers);
        Principal actor = new Principal("Actor", "/N", "Self");
        ArrayList<Principal> actors = new ArrayList<>();
        actors.add(actor);
        Movie movie = new Movie(titleId, titleInformation, false, titleDate, 54, genres, crew, actors);

        assertEquals(movie.getTitleId(), titleId);

        // Title asserts
        assertEquals(movie.getTitleInformation().getTitleType(), titleInformation.getTitleType());
        assertEquals(movie.getTitleInformation().getPrimaryTitle(), titleInformation.getPrimaryTitle());
        assertEquals(movie.getTitleInformation().getOriginalTitle(), titleInformation.getOriginalTitle());

        // Title date asserts
        assertEquals(movie.getTitleDate().getStartYear(), titleDate.getStartYear());
        assertEquals(movie.getTitleDate().getEndYear(), titleDate.getEndYear());

        // Genres assert
        assertEquals(movie.getGenres().get(0).getName(), genres.get(0).getName());
        assertEquals(movie.getGenres().get(0).getProduction(), genres.get(0).getProduction());

        // Crew asserts
        assertEquals(movie.getCrew().getWriters().get(0).getCategory(), crew.getWriters().get(0).getCategory());
        assertEquals(movie.getCrew().getWriters().get(0).getCharacters(), crew.getWriters().get(0).getCharacters());
        assertEquals(movie.getCrew().getWriters().get(0).getJob(), crew.getWriters().get(0).getJob());

        assertEquals(movie.getCrew().getDirectors().get(0).getCategory(), crew.getDirectors().get(0).getCategory());
        assertEquals(movie.getCrew().getDirectors().get(0).getCharacters(), crew.getDirectors().get(0).getCharacters());
        assertEquals(movie.getCrew().getDirectors().get(0).getJob(), crew.getDirectors().get(0).getJob());

        // Principals asserts
        assertEquals(movie.getPrincipals().get(0).getCategory(), actors.get(0).getCategory());
        assertEquals(movie.getPrincipals().get(0).getJob(), actors.get(0).getJob());
        assertEquals(movie.getPrincipals().get(0).getCharacters(), actors.get(0).getCharacters());

    }
}
