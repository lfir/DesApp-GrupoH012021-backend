package ar.edu.unq.desapp.grupoh.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class APIUsageRecord {
	@Id
	@GeneratedValue
	private Long id;
	private String platformName;
	private String action;
	private LocalDate date;
	
	public APIUsageRecord(String platformName, String action, LocalDate date) {
		this.platformName = platformName;
		this.action = action;
		this.date = date;
	}
}
