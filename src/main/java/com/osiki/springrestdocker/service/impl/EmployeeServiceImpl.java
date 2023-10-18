package com.osiki.springrestdocker.service.impl;

import com.osiki.springrestdocker.model.Employee;
import com.osiki.springrestdocker.repository.InMemoryRepository;
import com.osiki.springrestdocker.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private InMemoryRepository inMemoryRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        Employee employee1 = Employee.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .username(employee.getUsername())
                .build();

        inMemoryRepository.save(employee1);

        return employee;

    }

    @Override
    public List<Employee> getAllEmployees() {
       List<Employee> employee = inMemoryRepository.findAll();
       employee
               .stream()
               .map(emp -> new Employee(emp.getId(), emp.getFirstName(),
                       emp.getLastName(), emp.getUsername()))
               .collect(Collectors.toList());


        return employee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = inMemoryRepository.findById(id).get();


        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee employee1 = inMemoryRepository.findById(id).get();

        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee1.getLastName());
        employee1.setUsername(employee1.getUsername());

        inMemoryRepository.save(employee1);

        return employee;



    }

    @Override
    public Boolean deleteEmployee(Long id) {
        Employee employee = inMemoryRepository.findById(id).get();
        inMemoryRepository.delete(employee);

        return true;
    }
}
