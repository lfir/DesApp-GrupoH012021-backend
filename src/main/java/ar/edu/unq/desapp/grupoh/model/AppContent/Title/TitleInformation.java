package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
