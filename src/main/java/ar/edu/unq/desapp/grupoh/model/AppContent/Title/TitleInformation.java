package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TitleInformation {
    String titleType;
    String primaryTitle;
    String originalTitle;

    public TitleInformation (String titleType, String primaryTitle, String originalTitle) {
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
    }

}
