package com.cts.controller;

import com.cts.model.BankAccount;
import com.cts.service.BankService;

public class Mycontroller {

	public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice", 3000);
        BankAccount bob = new BankAccount("Bob", 1000);

        BankService service = new BankService();

        service.transfer(alice, bob, 2500); // Will trigger warning for low balance
        service.transfer(alice, bob, 1000); // Will trigger error for insufficient funds
    }
}
