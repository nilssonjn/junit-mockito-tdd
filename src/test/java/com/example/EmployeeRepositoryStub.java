package com.example;

import java.util.Arrays;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        return Arrays.asList(new Employee("1", 10000.00),
                new Employee("2", 20000.00));
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}