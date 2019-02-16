package org.wecancodeit.studentinformation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentInformationApplicationTests {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private StudentController studentController;
	
	//smoke test...sanity check
	@Test
	public void contextLoads() {
		assertThat(studentRepo).isNotNull();
		assertThat(studentController).isNotNull();
	}

}

