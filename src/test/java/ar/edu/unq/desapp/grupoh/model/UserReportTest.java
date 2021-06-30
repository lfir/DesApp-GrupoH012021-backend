package ar.edu.unq.desapp.grupoh.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class UserReportTest {
	@Test
	void whenValidDataThenUserReportWithCorrectFieldsIsCreated() {
		UserReport userReport = new UserReport();
		userReport.setAuthor("Bruce Willis");
		userReport.setDate(LocalDate.now());
		userReport.setId(Long.valueOf("2"));
		userReport.setMessage("Test message");
		
		assertTrue(String.class.isInstance(userReport.getAuthor()));
		assertTrue(LocalDate.class.isInstance(userReport.getDate()));
		assertTrue(Long.class.isInstance(userReport.getId()));
		assertTrue(String.class.isInstance(userReport.getMessage()));
	}
}
