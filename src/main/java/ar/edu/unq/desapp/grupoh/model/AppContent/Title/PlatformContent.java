package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "platform_content")
public abstract class PlatformContent {
    @Id
    String titleId;
    @OneToOne
    TitleInformation titleInformation;
    Boolean isAdult;
    @OneToOne
    TitleDate titleDate;
    Integer runtimeMinutes ;
    @OneToMany
    List<Genre> genres;
    @OneToOne
    Crew crew;
    @OneToMany
    List<Principal> principals;

    public PlatformContent(String titleId, TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate, Integer runtimeMinutes , List<Genre> genres, Crew crew, List<Principal> principals) {
        this.titleId = titleId;
        this.titleInformation = titleInformation;
        this.isAdult = isAdult;
        this.titleDate = titleDate;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
        this.crew = crew;
        this.principals = principals;
    }
}
