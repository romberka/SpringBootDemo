package com.amwater.microservices.demo;

import static com.amwater.microservices.demo.EmployeePredicates.isAdultMale;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

// POJO unit test
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class PojoTest {

	private Employee employee; 
	
	@Test
	public void adultMaleTest() throws Exception {
		employee = new Employee();
		employee.setAge(21);
		employee.setGender("M");
		boolean result = isAdultMale().test(employee);
		assertThat(result).isFalse();
		
		employee.setAge(22);
		employee.setGender("M");
		result = isAdultMale().test(employee);
		assertThat(result).isTrue();
		
		employee.setAge(22);
		employee.setGender("F");
		result = isAdultMale().test(employee);
		assertThat(result).isFalse();
    }
}