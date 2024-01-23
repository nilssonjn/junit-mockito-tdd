package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

    Employee employee;
    @BeforeEach
    void setUp() {
        employee = new Employee("John", 15000.00);
    }

    @Test
    @DisplayName("Verify employee initialization")
    void verifyEmployeeInitialization() {

        assertThat(employee.getId()).isEqualTo("John");
        assertThat(employee.getSalary()).isEqualTo(15000.00);
    }

    @Test
    @DisplayName("Assure setId sets an id")
    void assureSetIdSetsAnId() {
        String newId = "5";
        employee.setId(newId);

        assertThat(employee.getId()).isEqualTo("5");
    }

    @Test
    @DisplayName("Assure setSalary updates a new salary")
    void assureSetSalaryUpdatesANewSalary() {
        double updatedSalary = 20000.00;
        employee.setSalary(updatedSalary);

        assertThat(employee.getSalary()).isEqualTo(20000.00);
    }

    @Test
    @DisplayName("Assure isPaid returns correct value")
    void assureIsPaidReturnsCorrectValue() {
        employee.setPaid(false);

        assertThat(employee.isPaid()).isEqualTo(false);
    }

    @Test
    @DisplayName("Assure setPaid returns correct value")
    void assureSetPaidReturnsCorrectValue() {
        employee.setPaid(true);

        assertThat(employee.isPaid()).isEqualTo(true);
    }

    @Test
    @DisplayName("Test toString method")
    void testToStringMethod() {
        String result = employee.toString();

        assertThat(result).isEqualTo("Employee [id=John, salary=15000.0]");
    }
}