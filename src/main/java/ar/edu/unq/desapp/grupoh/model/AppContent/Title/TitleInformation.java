package ar.edu.unq.desapp.grupoh.model.AppContent.Title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TitleInformation {
    @Id
    @GeneratedValue
    Long id;
    String titleType;
    String primaryTitle;
    String originalTitle;

    public TitleInformation (String titleType, String primaryTitle, String originalTitle) {
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
    }

}
