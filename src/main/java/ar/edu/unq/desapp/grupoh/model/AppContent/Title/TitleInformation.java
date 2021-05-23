package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TitleInformation {
    @Id
    @GeneratedValue
    private Long id;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;

    public TitleInformation(String titleType, String primaryTitle, String originalTitle) {
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
    }

}
