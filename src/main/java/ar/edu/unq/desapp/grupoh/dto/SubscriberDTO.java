package ar.edu.unq.desapp.grupoh.dto;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubscriberDTO {
    @NonNull
    public String contentImdbId;
    @NonNull
    public ClientPlatform platform;
    @NonNull
    public String url;
}
