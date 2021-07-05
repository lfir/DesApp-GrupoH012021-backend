package ar.edu.unq.desapp.grupoh.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoh.exception.UnauthorizedException;
import ar.edu.unq.desapp.grupoh.model.APIUsageRecord;
import ar.edu.unq.desapp.grupoh.persistence.APIUsageRecordRepository;

@Service
public class APIUsageService {
	@Autowired
	private APIUsageRecordRepository usageRepository;
	@Autowired
	private ClientPlatformService clientService;

	public void add(String platformName, String action, LocalDate date) {
		APIUsageRecord usageRecord = new APIUsageRecord(platformName, action, date);
		this.usageRepository.save(usageRecord);
	}

	public List<APIUsageRecord> get(String username, String apiKey) {
		if (!this.clientService.get(apiKey).get().getUsername().equals(username)) {
			throw new UnauthorizedException();
		}
		return this.usageRepository.findByName(this.clientService.get(apiKey).get().getPlatformName());
	}
}
