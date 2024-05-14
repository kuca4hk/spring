package org.example.jkbe.repository;

import org.example.jkbe.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{


}
