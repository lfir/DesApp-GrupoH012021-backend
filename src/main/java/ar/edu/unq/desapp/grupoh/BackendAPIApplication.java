package ar.edu.unq.desapp.grupoh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAPIApplication.class, args);
	}
}
