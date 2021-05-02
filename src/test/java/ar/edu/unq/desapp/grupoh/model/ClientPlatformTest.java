package ar.edu.unq.desapp.grupoh.model;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClientPlatformTest {

	@Test
	void whenValidDataThenClientPlatformWithCorrectFieldsIsCreated() {
		ClientPlatform cp = new ClientPlatform();
		cp.setApiKey("testapikey0");
		cp.setId(Long.valueOf("0"));
		cp.setPassword("testPassword");
		cp.setUsername("testClientPlatformUsername");
		cp.setPlatformName("Netflix");
		
		ClientPlatform cp2 = new ClientPlatform("testClientPlatformUsername2", "testPassword2", "testapikey1", "Netflix");
		
		assertTrue(String.class.isInstance(cp.getApiKey()));
		assertTrue(Long.class.isInstance(cp.getId()));
		assertTrue(String.class.isInstance(cp.getPassword()));
		assertTrue(String.class.isInstance(cp.getUsername()));
		assertTrue(String.class.isInstance(cp.getPlatformName()));
		assertTrue(ClientPlatform.class.isInstance(cp2));
	}
}
