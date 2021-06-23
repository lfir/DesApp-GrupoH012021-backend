package ar.edu.unq.desapp.grupoh.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.model.Review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PlatformContentReviewBinder {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private PlatformContent platformContent;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Review> reviews;
	
	public PlatformContentReviewBinder(PlatformContent platformContent, List<Review> reviews) {
		this.platformContent = platformContent;
		this.reviews = reviews;
	}

	public String getPlatformContentImdbId() {
		return this.platformContent.getTitleId();
	}

	public List<String> getPlatformContentBasicInfo() {
		List<String> basicInfo = new ArrayList<>();
		basicInfo.add(this.getPlatformContentImdbId());
		basicInfo.add(this.platformContent.getTitleInformation().getOriginalTitle());
		basicInfo.add(String.valueOf(this.platformContent.getTitleDate().getStartYear().getYear()));
		basicInfo.add(this.platformContent.getRuntimeMinutes().toString());
		basicInfo.add(this.platformContent.getIsAdult().toString());
		
		return basicInfo;
	}
}
