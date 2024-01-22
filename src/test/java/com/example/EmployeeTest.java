package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    @DisplayName("Verify employee initialization")
    void verifyEmployeeInitialization() {
        Employee employee = new Employee("John", 15000);

        assertThat(employee.getId()).isEqualTo("John");
        assertThat(employee.getSalary()).isEqualTo(15000);
    }
}