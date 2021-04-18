package ar.edu.unq.desapp.grupoh.model;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClientPlatformTest {

	@Test
	void whenValidDataThenClientPlatformWithCorrectFieldsIsCreated() {
		ClientPlatform cp = new ClientPlatform();
		cp.setApiKey("testapikey0");
		cp.setId("id0");
		cp.setPassword("testPassword");
		cp.setUsername("testClientPlatformUsername");
		
		ClientPlatform cp2 = new ClientPlatform("testapikey1", "id1", "testPassword2", "testClientPlatformUsername2");
		
		assertTrue(String.class.isInstance(cp.getApiKey()));
		assertTrue(String.class.isInstance(cp.getId()));
		assertTrue(String.class.isInstance(cp.getPassword()));
		assertTrue(String.class.isInstance(cp.getUsername()));
		assertTrue(ClientPlatform.class.isInstance(cp2));
	}
}
