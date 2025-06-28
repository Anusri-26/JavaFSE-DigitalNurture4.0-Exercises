UPDATE Customers SET DOB = TO_DATE('1950-01-01', 'YYYY-MM-DD') WHERE CustomerID = 3;

BEGIN
  FOR c IN (SELECT CustomerID, Name, DOB FROM Customers) LOOP
    IF MONTHS_BETWEEN(SYSDATE, c.DOB)/12 > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = c.CustomerID;
      
      DBMS_OUTPUT.PUT_LINE('Discount applied to Customer: ' || c.Name || ' (ID: ' || c.CustomerID || ')');
    END IF;
  END LOOP;
  COMMIT;
END;