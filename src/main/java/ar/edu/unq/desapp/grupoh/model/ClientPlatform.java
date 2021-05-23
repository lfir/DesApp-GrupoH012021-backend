package ar.edu.unq.desapp.grupoh.model;

import javax.persistence.Column;
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
public class ClientPlatform {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String username;
	private String password;
	@Column(unique = true)
	private String apiKey;
	@Column(unique = true)
	private String platformName;
	
	public ClientPlatform(String username, String password, String apiKey, String platformName) {
		this.username = username;
		this.password = password;
		this.apiKey = apiKey;
		this.platformName = platformName;
	}
}
