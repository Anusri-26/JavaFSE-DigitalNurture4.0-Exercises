CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR acc IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;

    DBMS_OUTPUT.PUT_LINE('Updated Account ID ' || acc.AccountID || 
                         ' with new balance: ' || (acc.Balance * 1.01));
  END LOOP;
  COMMIT;
END;
/


-- Execute:
BEGIN
  ProcessMonthlyInterest;
END;
