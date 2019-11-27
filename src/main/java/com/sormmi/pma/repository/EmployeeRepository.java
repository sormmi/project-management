package com.sormmi.pma.repository;

import com.sormmi.pma.dto.EmployeeProject;
import com.sormmi.pma.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(nativeQuery=true,
            value=
            "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " +
            "FROM EMPLOYEE e " +
            "LEFT JOIN PROJECT_EMPLOYEE pe ON e.employee_id = pe.employee_id " +
            "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
    List<EmployeeProject> employeeProjects();
}
