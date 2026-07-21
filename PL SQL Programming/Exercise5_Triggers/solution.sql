SET SERVEROUTPUT ON

CREATE OR REPLACE TRIGGER trg_update_customer_last_modified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

CREATE OR REPLACE TRIGGER trg_log_transaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (AuditID, TableName, Operation, ReferenceID, Message, CreatedAt)
    VALUES (
        Audit_Log_Seq.NEXTVAL,
        'Transactions',
        'INSERT',
        :NEW.TransactionID,
        'Transaction ' || :NEW.TransactionID || ' inserted for account ' || :NEW.AccountID,
        SYSDATE
    );
END;
/

CREATE OR REPLACE TRIGGER trg_check_transaction_rules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_account_balance Accounts.Balance%TYPE;
BEGIN
    IF :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20301, 'Transaction amount must be greater than zero.');
    END IF;

    IF :NEW.TransactionType NOT IN ('Deposit', 'Withdrawal') THEN
        RAISE_APPLICATION_ERROR(-20302, 'Transaction type must be Deposit or Withdrawal.');
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance
        INTO v_account_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_account_balance THEN
            RAISE_APPLICATION_ERROR(-20303, 'Withdrawal amount exceeds account balance.');
        END IF;
    END IF;
END;
/

UPDATE Customers
SET Balance = Balance + 500
WHERE CustomerID = 1;

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (Transaction_Seq.NEXTVAL, 1, SYSDATE, 250, 'Deposit');

COMMIT;

SELECT AuditID, TableName, Operation, ReferenceID, Message, CreatedAt
FROM AuditLog
ORDER BY AuditID;
