package ar.edu.unq.desapp.grupoh.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import ar.edu.unq.desapp.grupoh.persistence.ClientPlatformRepository;

@Service
public class ClientPlatformService {
	@Autowired
	private ClientPlatformRepository clientRepository;
	
	public String add(AddClientPlatformRequestBody requestBody) {
		String apiKey = UUID.randomUUID().toString();
		ClientPlatform clientPlatform = new ClientPlatform(
			requestBody.getUsername(), requestBody.getPassword(), 
			apiKey, requestBody.getPlatformName()
		);
		this.clientRepository.save(clientPlatform);
		return apiKey;
	}
}
