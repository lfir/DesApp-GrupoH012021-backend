package ar.edu.unq.desapp.grupoh.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoh.model.APIUsageRecord;
import ar.edu.unq.desapp.grupoh.service.APIUsageService;

@RestController
public class PlatformUsageController {
	@Autowired
	private APIUsageService usageService;
	
	@CrossOrigin
	@GetMapping("/api/platformusage")
	public ResponseEntity<List<APIUsageRecord>> getUsageRecordsOf(
		@RequestParam(value = "platformname") String username,
		@RequestHeader(value = "Api-key") String apiKey
	) {
		return ResponseEntity.ok(this.usageService.get(username, apiKey));
	}
}
