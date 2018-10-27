package com.prateek.springdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.prateek.springdata.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}
