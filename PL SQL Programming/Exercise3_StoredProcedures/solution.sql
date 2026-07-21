SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE UPPER(AccountType) = 'SAVINGS';

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' savings account(s) updated with monthly interest.');
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department    IN Employees.Department%TYPE,
    p_bonus_percent IN NUMBER
) AS
BEGIN
    IF p_bonus_percent < 0 THEN
        RAISE_APPLICATION_ERROR(-20101, 'Bonus percentage cannot be negative.');
    END IF;

    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE UPPER(Department) = UPPER(p_department);

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employee(s) received bonus in department ' || p_department || '.');
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN Accounts.AccountID%TYPE,
    p_to_account_id   IN Accounts.AccountID%TYPE,
    p_amount          IN NUMBER
) AS
    v_source_balance Accounts.Balance%TYPE;
    v_target_count NUMBER;
BEGIN
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20111, 'Transfer amount must be greater than zero.');
    END IF;

    SELECT Balance
    INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id
    FOR UPDATE;

    SELECT COUNT(*)
    INTO v_target_count
    FROM Accounts
    WHERE AccountID = p_to_account_id;

    IF v_target_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20112, 'Target account does not exist.');
    END IF;

    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20113, 'Source account has insufficient balance.');
    END IF;

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transaction_Seq.NEXTVAL, p_from_account_id, SYSDATE, p_amount, 'Withdrawal');

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transaction_Seq.NEXTVAL, p_to_account_id, SYSDATE, p_amount, 'Deposit');

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account_id;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from account ' || p_from_account_id || ' to account ' || p_to_account_id || '.');
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: source account does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

BEGIN
    ProcessMonthlyInterest;
    UpdateEmployeeBonus('IT', 8);
    TransferFunds(1, 2, 50);
END;
/
