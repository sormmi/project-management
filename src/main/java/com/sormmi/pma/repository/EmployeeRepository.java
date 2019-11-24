package com.sormmi.pma.repository;

import com.sormmi.pma.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
