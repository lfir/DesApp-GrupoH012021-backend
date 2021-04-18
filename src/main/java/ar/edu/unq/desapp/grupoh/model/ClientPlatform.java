package ar.edu.unq.desapp.grupoh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientPlatform {
	private String id;
	private String username;
	private String password;
	private String apiKey;
}
