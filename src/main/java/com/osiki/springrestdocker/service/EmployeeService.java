package com.osiki.springrestdocker.service;

import com.osiki.springrestdocker.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void updateEmployee(Employee employee, Long id);

    Boolean deleteEmployee(Long id);
}
