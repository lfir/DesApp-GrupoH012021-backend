package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import ar.edu.unq.desapp.grupoh.model.AppContent.Subscriber;
import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.edu.unq.desapp.grupoh.model.PlatformContentReviewBinder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "platform_content")
public abstract class PlatformContent {
    @Id
    private String titleId;
    @OneToOne
    private TitleInformation titleInformation;
    private Boolean isAdult;
    @OneToOne
    private TitleDate titleDate;
    private Integer runtimeMinutes;
    @OneToMany
    private List<Genre> genres;
    @OneToOne
    private Crew crew;
    @OneToMany
    private List<Principal> principals;
    @OneToOne
    @JsonIgnore
    private PlatformContentReviewBinder binder;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Subscriber> subscribers;

    public PlatformContent(
            String titleId, TitleInformation titleInformation, Boolean isAdult, TitleDate titleDate,
            Integer runtimeMinutes , List<Genre> genres, Crew crew, List<Principal> principals
    ) {
        this.titleId = titleId;
        this.titleInformation = titleInformation;
        this.isAdult = isAdult;
        this.titleDate = titleDate;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
        this.crew = crew;
        this.principals = principals;
        this.subscribers = new ArrayList<>();
    }
}
