# PL/SQL Practice: Control Structures & Stored Procedures

## Overview

This repository includes practical PL/SQL scenarios for banking systems, focusing on:

- **Exercise 1: Control Structures**
- **Exercise 3: Stored Procedures**

---

## Exercise 1 – Control Structures

Use conditional logic and iterative constructs to automate business processes.

### Scenarios

1. **Senior Loan Discount**  
   Apply a 1% discount to loan interest rates for customers over 60 years old.

2. **VIP Promotion**  
   Set `IsVIP` flag to TRUE for customers with a balance over $10,000.

3. **Loan Reminders**  
   Fetch loans due within the next 30 days and print reminder messages for each customer.

### Objectives

- Practice `IF` statements and loops.
- Apply business rules dynamically.
- Work with date operations and conditional updates.

---

## Exercise 3 – Stored Procedures

Encapsulate business logic into reusable PL/SQL stored procedures.

### Scenarios

1. **Monthly Interest Processing**  
   Apply a 1% interest rate to all savings accounts and update their balances.

2. **Bonus Update**  
   Update employee salaries within a department by applying a bonus percentage.

3. **Fund Transfer Between Accounts**  
   Transfer funds between accounts after checking sufficient balance.

### Objectives

- Create parameterized procedures.
- Implement transaction logic.
- Use validation and data consistency techniques.

---

## Schema Reference

Tables used:
- `Customers`
- `Accounts`
- `Loans`
- `Employees`

Sample data provided for all tables to support testing.

---

## Getting Started

- Load the schema and insert sample data.
- Test each exercise independently using anonymous blocks or procedure calls.

---
