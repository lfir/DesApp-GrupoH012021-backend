package ar.edu.unq.desapp.grupoh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoh.dto.ClientPlatformDTO;
import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import ar.edu.unq.desapp.grupoh.persistence.ClientPlatformRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class ClientPlatformService {
	@Autowired
	private ClientPlatformRepository clientRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	SecretService secretService;
	
	@Transactional
	public String add(ClientPlatformDTO requestBody) {
		byte[] jwtSigningSecret = this.secretService.getSecretBytes();
		JwtBuilder jws = Jwts.builder()
	        .setIssuer("Re-seña!")
	        .setSubject(requestBody.getPlatformName())
	        .signWith(SignatureAlgorithm.HS512, jwtSigningSecret);

		String apiKey = jws.compact();
		String hashedPassword = this.passwordEncoder.encode(requestBody.getPassword());
		ClientPlatform clientPlatform = new ClientPlatform(
			requestBody.getUsername(), hashedPassword, 
			apiKey, requestBody.getPlatformName()
		);
		
		this.clientRepository.save(clientPlatform);
		return apiKey;
	}

	public Optional<ClientPlatform> get(String apiKey) {
		return this.clientRepository.findByApiKey(apiKey);
	}
}
