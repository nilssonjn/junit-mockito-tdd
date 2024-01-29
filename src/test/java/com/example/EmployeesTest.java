package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeesTest {

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    BankService bankService;

    @InjectMocks
    Employees employees;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        bankService = mock(BankService.class);
        employees = new Employees(employeeRepository, bankService);

    }

    @Test
    @DisplayName("Given employee mock should return isPaid true")
    void givenEmployeeMockShouldReturnIsPaidTrue() {
        Employee employee = new Employee("1", 10000.00);

        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        employees.payEmployees();

        assertThat(employee.isPaid()).isEqualTo(true);
    }

    @Test
    @DisplayName("Given mock employee make sure successful payment returns number of payments")
    void givenMockEmployeeMakeSureSuccessfulPaymentReturnsNumberOfPayments() {
        EmployeeRepository employeeRepositoryStub = new EmployeeRepositoryStub();
        BankService bankServiceStub = new BankServiceStub();
        Employees employees = new Employees(employeeRepositoryStub, bankServiceStub);

        var result = employees.payEmployees();

        assertThat(result).isEqualTo(2);
    }
}