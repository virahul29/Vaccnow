package org.nagarro.vaccnow.availability;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.nagarro.vaccnow.VaccNowApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VaccNowApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class VaccinationTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testConfirmVaccinationTimeslot() {

		// GetAllBranch
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<String[]> response = restTemplate.exchange(createURLWithPort("/vaccnow/vaccination/confirm-vaccination/test@gmail.com"),
				HttpMethod.GET, entity, String[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertArrayEquals(new String[] { "Covid" }, response.getBody());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
