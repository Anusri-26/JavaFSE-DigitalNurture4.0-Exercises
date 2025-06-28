CREATE OR REPLACE PROCEDURE TransferFunds (
  from_acc IN NUMBER,
  to_acc IN NUMBER,
  amount IN NUMBER
) IS
  from_balance NUMBER;
BEGIN
  SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_acc FOR UPDATE;

  IF from_balance >= amount THEN
    UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = from_acc;
    UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = to_acc;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || amount || 
                         ' from Account ' || from_acc || 
                         ' to Account ' || to_acc);
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient funds in Account ID ' || from_acc);
  END IF;
  COMMIT;
END;
/

-- Example execution:
BEGIN
  TransferFunds(1, 2, 500);
END;
