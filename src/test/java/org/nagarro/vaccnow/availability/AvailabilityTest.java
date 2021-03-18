package org.nagarro.vaccnow.availability;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

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
import com.nagarro.vaccnow.dto.BranchDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VaccNowApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class AvailabilityTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetAllBranch() {

		// GetAllBranch
		HttpEntity<String> entity1 = new HttpEntity<String>(headers);

		ResponseEntity<String[]> response1 = restTemplate.exchange(createURLWithPort("/vaccnow/availability/branch"),
				HttpMethod.GET, entity1, String[].class);

		assertEquals(HttpStatus.OK, response1.getStatusCode());
		assertArrayEquals(new String[] { "pune" }, response1.getBody());
	}

	@Test
	public void testGetAllVaccineByBranch() {

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String[]> response2 = restTemplate.exchange(
				createURLWithPort("/vaccnow/availability/list-vaccines/1"), HttpMethod.GET, entity, String[].class);

		assertEquals(HttpStatus.OK, response2.getStatusCode());
		assertArrayEquals(new String[] { "Covid" }, response2.getBody());

	}

	@Test
	public void testGetavailableTimeSlots() {

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<BranchDto> response3 = restTemplate.exchange(
				createURLWithPort("/vaccnow/availability/available-timeslots/1"), HttpMethod.GET, entity,
				BranchDto.class);

		List<String> slots = Arrays.asList("2021-03-17 01:00", "2021-03-17 01:15", "2021-03-17 01:30",
				"2021-03-17 01:45", "2021-03-17 02:00");
		BranchDto branchDto = new BranchDto();
		branchDto.setId(1);
		branchDto.setBranchName("pune");
		branchDto.setTimeFrom(Time.valueOf("01:00:00"));
		branchDto.setTimeTo(Time.valueOf("02:00:00"));
		branchDto.setVaccines(null);
		branchDto.setSlots(slots);
		assertEquals(HttpStatus.OK, response3.getStatusCode());
//		assertEquals(branchDto, response3.getBody());

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
