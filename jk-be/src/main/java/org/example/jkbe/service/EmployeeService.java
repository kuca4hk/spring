package org.example.jkbe.service;

import org.example.jkbe.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(long id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(long id, EmployeeDTO employeeDTO);

    void dedeleteEmployee(long id);
}
