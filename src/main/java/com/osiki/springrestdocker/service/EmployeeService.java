package com.osiki.springrestdocker.service;

import com.osiki.springrestdocker.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee, Long id);

    Boolean deleteEmployee(Long id);
}
