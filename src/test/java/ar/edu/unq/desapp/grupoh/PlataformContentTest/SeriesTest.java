package ar.edu.unq.desapp.grupoh.PlataformContentTest;

import ar.edu.unq.desapp.grupoh.model.AppContent.Episode;
import ar.edu.unq.desapp.grupoh.model.AppContent.Series;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeriesTest {
    @Test
    void whenValidDataThenSeriesWithCorrectDataIsCreated () {
    	String titleId = "as2d2d";
    	
        TitleInformation titleInformation = new TitleInformation("short", "The Sea", "Baignade en mer");
        titleInformation.setId(Long.valueOf("1"));
        
        TitleDate titleDate = new TitleDate(LocalDate.parse("1985-10-10"), null);
        titleDate.setId(Long.valueOf("3"));
        
        ArrayList<Genre> genres = new ArrayList<>();
        Genre testGenre = new Genre();
        testGenre.setId(Long.valueOf("12"));
        testGenre.setName("Historical");
        testGenre.setProduction("Cine");
        genres.add(testGenre);
        genres.add(new Genre("Short", "Cine"));
        
        Principal director = new Principal("Director", "Director of photography", "/N");
        Principal writer = new Principal();
        writer.setId(Long.valueOf("1"));
        writer.setCategory("Writer");
        writer.setCharacters("Writer");
        writer.setJob("/N");
        ArrayList<Principal> directors = new ArrayList<>();
        directors.add(director);
        ArrayList<Principal> writers = new ArrayList<>();
        writers.add(writer);
        Crew crew = new Crew(directors, writers);
        crew.setId(Long.valueOf("2"));
        
        Principal actor = new Principal("Actor", "/N", "Self");
        ArrayList<Principal> actors = new ArrayList<>();
        actors.add(actor);

        Episode episode1 = new Episode();
        episode1.setSeasonNumber(1);
        episode1.setEpisodeNumber(1);
        Episode episode2 = new Episode(1,2);

        ArrayList<Episode> episodes = new ArrayList<>();
        episodes.add(episode1);
        episodes.add(episode2);
        Series series = new Series(titleId, titleInformation, false, titleDate, 54, genres, crew, actors, episodes);
        Series series2 = new Series();
        series2.setEpisodes(episodes);
        
        assertTrue(Series.class.isInstance(series2));
        assertTrue(Episode.class.isInstance(series2.getEpisodes().get(0)));
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
