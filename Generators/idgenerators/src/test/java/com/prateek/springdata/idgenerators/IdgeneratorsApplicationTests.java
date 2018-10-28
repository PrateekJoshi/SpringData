package com.prateek.springdata.idgenerators;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prateek.springdata.idgenerators.entities.Employee;
import com.prateek.springdata.idgenerators.repos.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.prateek.springdata.idgenerators.IdgeneratorsApplication.class)

public class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository repository;
	
	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("Prateek Joshi");	 //we have not provided id, db will generate it for us (@GeneratedValue(strategy=GenerationType.IDENTITY))
		repository.save(employee);
	}

}
