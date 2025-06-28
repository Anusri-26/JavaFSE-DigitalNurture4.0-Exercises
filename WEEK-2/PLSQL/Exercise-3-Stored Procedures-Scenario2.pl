CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  dept IN VARCHAR2,
  bonus_percent IN NUMBER
) IS
BEGIN
  FOR emp IN (SELECT EmployeeID, Name, Salary FROM Employees WHERE Department = dept) LOOP
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE EmployeeID = emp.EmployeeID;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to ' || emp.Name || 
                         ' (New Salary: ' || (emp.Salary * (1 + bonus_percent / 100)) || ')');
  END LOOP;
  COMMIT;
END;
/

-- Example execution:
BEGIN
  UpdateEmployeeBonus('IT', 10);
END;
