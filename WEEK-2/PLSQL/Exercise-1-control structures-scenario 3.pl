UPDATE Loans SET EndDate = SYSDATE + 10 WHERE LoanID = 1;
BEGIN
  FOR l IN (
    SELECT l.LoanID, l.EndDate, c.Name
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || l.LoanID || 
                         ' for ' || l.Name || 
                         ' is due on ' || TO_CHAR(l.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
