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
public class UserReport {
	@Id
    @GeneratedValue
	private Long id;
	private LocalDate date;
	private String message;
	private String author;
}
