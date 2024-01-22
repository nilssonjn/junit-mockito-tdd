package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

    @Test
    @DisplayName("Verify employee initialization")
    void verifyEmployeeInitialization() {
        Employee employee = new Employee("John", 15000);

        assertThat(employee.getId()).isEqualTo("John");
        assertThat(employee.getSalary()).isEqualTo(15000);
    }

    @Test
    @DisplayName("Assure setId sets an id")
    void assureSetIdSetsAnId() {
        Employee employee = new Employee("John", 15000);
        String newId = "5";
        employee.setId(newId);

        assertThat(employee.getId()).isEqualTo("5");
    }

    @Test
    @DisplayName("Assure setSalary updates a new salary")
    void assureSetSalaryUpdatesANewSalary() {
        Employee employee = new Employee("John", 15000);
        double updatedSalary = 20000.0;
        employee.setSalary(updatedSalary);

        assertThat(employee.getSalary()).isEqualTo(20000.0);
    }

    @Test
    @DisplayName("Assure isPaid returns correct value")
    void assureIsPaidReturnsCorrectValue() {
        Employee employee = new Employee("John", 20000.0);
        employee.setPaid(true);

        assertThat(employee.isPaid()).isEqualTo(true);
    }

    @Test
    @DisplayName("Assure setPaid returns correct value")
    void assureSetPaidReturnsCorrectValue() {
        Employee employee = new Employee("John", 20000.0);
        employee.setPaid(false);

        assertThat(employee.isPaid()).isEqualTo(false);
    }

    @Test
    @DisplayName("Test toString method")
    void testToStringMethod() {
        Employee employee = new Employee("John", 15000.0);
        String result = employee.toString();

        assertThat(result).isEqualTo("Employee [id=John, salary=15000.0]");
    }
}