package org.example.jkbe.service.impl;

import lombok.AllArgsConstructor;
import org.example.jkbe.dto.EmployeeDTO;
import org.example.jkbe.entity.Employee;
import org.example.jkbe.exception.ResourceNotFoundException;
import org.example.jkbe.mapper.EmployeeMapper;
import org.example.jkbe.repository.EmployeeRepository;
import org.example.jkbe.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employee);

        return  EmployeeMapper.mapToEmployeeDTO(savedEmployee);

    }

    @Override
    public EmployeeDTO getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDTO).toList();
    }

    @Override
    public EmployeeDTO updateEmployee(long id, EmployeeDTO updateEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Employee updateEmployeeObj =  employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(updateEmployeeObj);
    }

    @Override
    public void dedeleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
//        employeeRepository.delete(employee);
        employeeRepository.deleteById(id);
    }


}
