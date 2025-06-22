# Week 1

This project includes implementations for the following exercises:

-Design Principles and Patterns
1. ✅ Exercise 1: Singleton Pattern  
2. ✅ Exercise 2: Factory Method Pattern  

-Data Structures and Algorithms
3. ✅ Exercise 2: E-commerce Platform Search Function  
4. ✅ Exercise 7: Financial Forecasting  

Each section contains explanations, code logic, and actual output results.

---

## 🧠 Exercise 1: Singleton Pattern

### ✅ Scenario:
A logging utility must ensure a single instance throughout the application lifecycle.

---

### 🔍 Sub-question Answers:

- **What is Singleton?**  
  A design pattern that restricts instantiation of a class to one object.

- **How is Singleton ensured?**  
  - Private constructor  
  - Static instance  
  - `getInstance()` method  
  - Optional exception check inside constructor

- **Why Singleton?**  
  - Centralized logging  
  - Resource optimization  
  - Prevents multiple logger conflicts

---

### 🔨 Sample Output:
```
Logger has been set up successfully.
Log: Starting the system...
Log: Performing some tasks...
Confirmed: Both logger1 and logger2 refer to the same instance.
```

---

## 🏗️ Exercise 2: Factory Method Pattern

### ✅ Scenario:
Create different types of documents (Word, PDF, Excel) using the Factory Method Pattern.

---

### 🔍 Sub-question Answers:

- **What is the Factory Method Pattern?**  
  A creational design pattern that delegates object creation to subclasses.

- **Why use it?**  
  - Supports Open/Closed Principle  
  - Makes the code extensible for future document types  
  - Avoids direct instantiation in main class

- **How it works:**  
  - `Document`: abstract base  
  - `WordDocument`, `PdfDocument`, `ExcelDocument`: concrete implementations  
  - `DocumentFactory`: abstract creator  
  - Each document type has a factory class

---

### 🔨 Sample Output:
```
Opening a Word document.
Opening a PDF document.
Opening an Excel document.
```

---

## 🛒 Exercise 2: E-commerce Platform Search Function

### ✅ Scenario:
Build a product search tool using linear and binary search techniques.

---

### 🔍 Sub-question Answers:

- **Big O Notation Overview:**
  - Linear Search: O(n)
  - Binary Search: O(log n) – Requires sorted array

- **Setup:**
  - Created `Item` class with `id`, `name`, `type`
  - Products collected via user input and stored in array

- **Search Methods:**
  - `searchByNameLinear()` for simple scan
  - `searchByNameBinary()` for efficient search post-sorting

---

### 🔨 Sample Output:
```
Enter number of products: 3

Enter details for product #1
Product ID: 101
Product Name: Laptop
Category: Electronics

Enter details for product #2
Product ID: 102
Product Name: Notebook
Category: Stationery

Enter details for product #3
Product ID: 103
Product Name: Mug
Category: Kitchen

Enter product name to search: Notebook
Linear Search Result: Product ID: 102 | Name: Notebook | Category: Stationery
Binary Search Result: Product ID: 102 | Name: Notebook | Category: Stationery

Time Complexity Analysis:
- Linear Search: O(n)
- Binary Search: O(log n) [on sorted data]
```

---

## 📈 Exercise 7: Financial Forecasting

### ✅ Scenario:
Develop a forecasting tool that uses recursion and memoization to compute future values based on annual growth rates.

---

### 🔍 Sub-question Answers:

- **What is recursion?**  
  A method where the solution to a problem depends on solutions to smaller subproblems.

- **Why use memoization?**  
  - Prevents redundant computations  
  - Reduces exponential time to linear

- **Time Complexity:**  
  - Without memoization: O(2^n)  
  - With memoization: O(n)

---

### 🔨 Sample Output:
```
Enter the starting amount (e.g., 1000): 1000
Enter forecast duration in years: 3
Input growth rate for each year (as percentage, e.g., 6 for 6%):
Year 1 growth rate: 5
Year 2 growth rate: 6
Year 3 growth rate: 4
Predicted value after 3 years: 1191.02

Time Complexity: O(n) due to memoized recursion.
Optimization: Memoization prevents redundant calculations and improves performance.
```

---

## 🧰 Technologies Used

- Java 8+
- OOP principles: abstraction, inheritance, polymorphism
- Design Patterns: Singleton, Factory Method
- Recursion and memoization
- Linear and binary search algorithms

---

## 💻 How to Run

```bash
javac SingletonPatternExample.java
java SingletonPatternExample

javac Main.java     # For Factory Method
java Main

javac ProductSearchTool.java
java ProductSearchTool

javac ForecastTool.java
java ForecastTool
```

---

## 📚 Summary

This submission demonstrates practical applications of:
- Singleton design for logging
- Factory Method for scalable document creation
- Search techniques using linear and binary algorithms
- Recursive forecasting with real-world growth rate inputs
