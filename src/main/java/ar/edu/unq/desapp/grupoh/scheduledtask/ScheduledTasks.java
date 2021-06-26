package ar.edu.unq.desapp.grupoh.scheduledtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ar.edu.unq.desapp.grupoh.service.CacheService;

@Component
public class ScheduledTasks {
	@Autowired
	private CacheService cacheService;
	private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Scheduled(cron="@daily") // Use */60 * * * * * to execute every minute
	public void updateCachedData() {
		this.cacheService.saveSummaryData();
		this.logger.info("Updated data on Redis Cache");
	}
}
