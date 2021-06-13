package ar.edu.unq.desapp.grupoh.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoh.model.APIUsageRecord;
import ar.edu.unq.desapp.grupoh.persistence.APIUsageRecordRepository;

@Service
public class APIUsageService {
	@Autowired
	private APIUsageRecordRepository usageRepository;

	public void add(String platformName, String action, LocalDate date) {
		APIUsageRecord usageRecord = new APIUsageRecord(platformName, action, date);
		this.usageRepository.save(usageRecord);
	}
}
