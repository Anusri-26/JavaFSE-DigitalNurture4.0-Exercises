ALTER TABLE Customers ADD IsVIP CHAR(1);
BEGIN
  FOR c IN (SELECT CustomerID, Name, Balance FROM Customers) LOOP
    IF c.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'Y'
      WHERE CustomerID = c.CustomerID;
      
      DBMS_OUTPUT.PUT_LINE('Customer promoted to VIP: ' || c.Name || ' (Balance: ' || c.Balance || ')');
    END IF;
  END LOOP;
  COMMIT;
END;
