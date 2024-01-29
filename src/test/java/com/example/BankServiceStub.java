package com.example;

public class BankServiceStub implements BankService {
    @Override
    public void pay(String id, double amount) {
        System.out.println("Simulating payment for employee: " + id);
    }
}