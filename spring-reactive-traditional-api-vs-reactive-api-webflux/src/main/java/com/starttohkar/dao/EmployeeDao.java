package com.starttohkar.dao;

import com.starttohkar.entity.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class EmployeeDao {


    private static void simulateDelay() {
        try {
            Thread.sleep(1000); // Simulate a delay of 100 milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public List<Employee> getAllEmployees() {
        // In a real application, this would fetch data from a database
        return IntStream.rangeClosed(1, 10)
                .peek(i -> simulateDelay()) // Simulate delay for each employee
                .peek(i-> System.out.println("Processing count : " + i))
                .mapToObj(i -> new Employee(i, "Employee " + i))
                .collect(Collectors.toList());
    }

    public Flux<Employee> getAllEmployeesWithFlux() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing count : " + i)) // Simulate delay for each employee
                .map(i -> new Employee(i, "Employee " + i));
    }
}
