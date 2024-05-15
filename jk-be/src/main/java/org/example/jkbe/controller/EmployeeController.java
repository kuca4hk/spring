package org.example.jkbe.controller;

import jakarta.persistence.PostUpdate;
import lombok.AllArgsConstructor;
import org.example.jkbe.dto.EmployeeDTO;
import org.example.jkbe.entity.Employee;
import org.example.jkbe.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Add employee endpoint
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get employee by id endpoint
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") long id) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping()
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") long id,@RequestBody EmployeeDTO updateEmployee){
        EmployeeDTO employeeDTO = employeeService.updateEmployee(id, updateEmployee);
        return ResponseEntity.ok(employeeDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> dedeleteEmployee(@PathVariable("id") long id){
        employeeService.dedeleteEmployee(id);
        return ResponseEntity.ok("Empoloyee was deleted");
    }
}
