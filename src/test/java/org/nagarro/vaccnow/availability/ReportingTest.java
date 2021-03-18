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
public class ReportingTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetAppliedVaccinationPerBranch() {

		// GetAllBranch
		HttpEntity<String> entity1 = new HttpEntity<String>(headers);

		ResponseEntity<String[]> response = restTemplate.exchange(createURLWithPort("/vaccnow/reporting/applied-vaccination-per-branch/1"),
				HttpMethod.GET, entity1, String[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertArrayEquals(new String[] { "Covid" }, response.getBody());
	}

	@Test
	public void testGetAppliedVaccinationByDatesAndBranch() {

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String[]> response2 = restTemplate.exchange(
				createURLWithPort("vaccnow/reporting/applied-vaccination-per-day/2021-03-17/2021-03-18/1"), HttpMethod.GET, entity, String[].class);

		assertEquals(HttpStatus.OK, response2.getStatusCode());
		assertArrayEquals(new String[] { "Covid" }, response2.getBody());

	}

	
	@Test
	public void testGetConfirmedVaccinations() {

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String[]> response2 = restTemplate.exchange(
				createURLWithPort("vaccnow/reporting/confirmed-vaccinations/2021-03-17/2021-03-18"), HttpMethod.GET, entity, String[].class);

		assertEquals(HttpStatus.OK, response2.getStatusCode());
		assertArrayEquals(new String[] { "Covid" }, response2.getBody());

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
