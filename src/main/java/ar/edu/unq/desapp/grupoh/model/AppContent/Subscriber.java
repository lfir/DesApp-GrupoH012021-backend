package ar.edu.unq.desapp.grupoh.model.AppContent;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contentImdbId;
    @OneToOne
    private ClientPlatform platform;
    private String url;

    public Subscriber (String contentImdbId, ClientPlatform platform, String url) {
        this.contentImdbId = contentImdbId;
        this.platform = platform;
        this.url = url;
    }
}
