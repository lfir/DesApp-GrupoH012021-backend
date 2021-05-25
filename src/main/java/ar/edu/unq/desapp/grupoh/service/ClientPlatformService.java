package ar.edu.unq.desapp.grupoh.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoh.dto.ClientPlatformDTO;
import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import ar.edu.unq.desapp.grupoh.persistence.ClientPlatformRepository;

@Service
public class ClientPlatformService {
	@Autowired
	private ClientPlatformRepository clientRepository;
	
	@Transactional
	public String add(ClientPlatformDTO requestBody) {
		String apiKey = UUID.randomUUID().toString();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(requestBody.getPassword());
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
