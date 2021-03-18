package org.nagarro.vaccnow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nagarro.vaccnow.VaccNowApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VaccNowApplication.class)
public class VaccineApplicationTests {

	@Test
	public void main() {
		VaccNowApplication.main(new String[] {});
	}
}
