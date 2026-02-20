package com.starttohkar.service;

import com.starttohkar.dao.EmployeeDao;
import com.starttohkar.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> loadAllEmployees() {
        Long startTime = System.currentTimeMillis();
        List<Employee> employees = employeeDao.getAllEmployees();
        Long endTime = System.currentTimeMillis();
        System.out.println("Total Execution Time taken to load employees: " + (endTime - startTime) + " ms");
        return employees;
    }

    public Flux<Employee> loadAllEmployeesWithFlux() {
        Long startTime = System.currentTimeMillis();
        Flux<Employee> employees = employeeDao.getAllEmployeesWithFlux();
        Long endTime = System.currentTimeMillis();
        System.out.println("Total Execution Time taken to load employees: " + (endTime - startTime) + " ms");
        return employees;
    }
}
