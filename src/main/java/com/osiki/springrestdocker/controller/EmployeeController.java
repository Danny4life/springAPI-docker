package com.osiki.springrestdocker.controller;

import com.osiki.springrestdocker.model.Employee;
import com.osiki.springrestdocker.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // save en employee to DB
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
       //return ResponseEntity.ok(employeeService.addEmployee(employee));

        return ResponseEntity.created(getLocation(employee.getId()))
                .body(employeeService.addEmployee(employee));

    }

    private URI getLocation(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
