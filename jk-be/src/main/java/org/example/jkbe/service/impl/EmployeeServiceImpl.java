package org.example.jkbe.service.impl;

import lombok.AllArgsConstructor;
import org.example.jkbe.dto.EmployeeDTO;
import org.example.jkbe.entity.Employee;
import org.example.jkbe.mapper.EmployeeMapper;
import org.example.jkbe.repository.EmployeeRepository;
import org.example.jkbe.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new EmployeeMapper.mapToEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employee);

        return  EmployeeMapper.mapToEmployeeDTO(savedEmployee);

    }


}
