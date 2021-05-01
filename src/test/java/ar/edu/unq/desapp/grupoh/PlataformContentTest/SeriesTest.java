package ar.edu.unq.desapp.grupoh.PlataformContentTest;

import ar.edu.unq.desapp.grupoh.model.AppContent.Episode;
import ar.edu.unq.desapp.grupoh.model.AppContent.Series;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeriesTest {
    @Test
    void whenValidDataThenSeriesWithCorrectDataIsCreated () {
        TitleInformation titleInformation = new TitleInformation("short", "The Sea", "Baignade en mer");
        String titleId = "as2d2d";
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

        Episode episode1 = new Episode(1,1);
        Episode episode2 = new Episode(1,2);

        ArrayList<Episode> episodes = new ArrayList<>();
        episodes.add(episode1);
        episodes.add(episode2);
        Series series = new Series(titleId, titleInformation, false, titleDate, 54, genres, crew, actors, episodes);

        assertEquals(series.getTitleId(), titleId);

        // Title asserts
        assertEquals(series.getTitleInformation().getTitleType(), titleInformation.getTitleType());
        assertEquals(series.getTitleInformation().getPrimaryTitle(), titleInformation.getPrimaryTitle());
        assertEquals(series.getTitleInformation().getOriginalTitle(), titleInformation.getOriginalTitle());

        // Title date asserts
        assertEquals(series.getTitleDate().getStartYear(), titleDate.getStartYear());
        assertEquals(series.getTitleDate().getEndYear(), titleDate.getEndYear());

        // Genres assert
        assertEquals(series.getGenres().get(0).getName(), genres.get(0).getName());
        assertEquals(series.getGenres().get(0).getProduction(), genres.get(0).getProduction());

        // Crew asserts
        assertEquals(series.getCrew().getWriters().get(0).getCategory(), crew.getWriters().get(0).getCategory());
        assertEquals(series.getCrew().getWriters().get(0).getCharacters(), crew.getWriters().get(0).getCharacters());
        assertEquals(series.getCrew().getWriters().get(0).getJob(), crew.getWriters().get(0).getJob());

        assertEquals(series.getCrew().getDirectors().get(0).getCategory(), crew.getDirectors().get(0).getCategory());
        assertEquals(series.getCrew().getDirectors().get(0).getCharacters(), crew.getDirectors().get(0).getCharacters());
        assertEquals(series.getCrew().getDirectors().get(0).getJob(), crew.getDirectors().get(0).getJob());

        // Principals asserts
        assertEquals(series.getPrincipals().get(0).getCategory(), actors.get(0).getCategory());
        assertEquals(series.getPrincipals().get(0).getJob(), actors.get(0).getJob());
        assertEquals(series.getPrincipals().get(0).getCharacters(), actors.get(0).getCharacters());

        // Episodes test
        assertEquals(series.getEpisodes().get(0).getEpisodeNumber(), episode1.getEpisodeNumber());
        assertEquals(series.getEpisodes().get(0).getSeasonNumber(), episode1.getSeasonNumber());

        assertEquals(series.getEpisodes().get(1).getEpisodeNumber(), episode2.getEpisodeNumber());
        assertEquals(series.getEpisodes().get(1).getSeasonNumber(), episode2.getSeasonNumber());

    }
}
