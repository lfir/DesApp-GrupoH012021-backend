package ar.edu.unq.desapp.grupoh.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class APIUsageRecordTest {
	@Test
	void whenValidDataThenAPIUsageRecordWithCorrectFieldsIsCreated() {
		APIUsageRecord usageRecord = new APIUsageRecord();
		usageRecord.setId(Long.valueOf("0"));
		usageRecord.setPlatformName("testPlatform");
		usageRecord.setAction("testAction");
		usageRecord.setDate(LocalDate.now());
		
		APIUsageRecord usageRecord2 = new APIUsageRecord("testClientPlatformName2", "testAction2", LocalDate.now());
		
		assertTrue(Long.class.isInstance(usageRecord.getId()));
		assertTrue(String.class.isInstance(usageRecord.getPlatformName()));
		assertTrue(String.class.isInstance(usageRecord.getAction()));
		assertTrue(LocalDate.class.isInstance(usageRecord.getDate()));
		assertTrue(APIUsageRecord.class.isInstance(usageRecord2));
	}
}
