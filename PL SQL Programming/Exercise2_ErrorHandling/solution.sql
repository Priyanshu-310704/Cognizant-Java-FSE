SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE Log_Error (
    p_procedure_name IN VARCHAR2,
    p_error_message  IN VARCHAR2
) AS
BEGIN
    INSERT INTO ErrorLog (ErrorID, ProcedureName, ErrorMessage, CreatedAt)
    VALUES (Error_Log_Seq.NEXTVAL, p_procedure_name, SUBSTR(p_error_message, 1, 4000), SYSDATE);
END;
/

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN Accounts.AccountID%TYPE,
    p_to_account_id   IN Accounts.AccountID%TYPE,
    p_amount          IN NUMBER
) AS
    v_from_balance Accounts.Balance%TYPE;
    v_to_exists NUMBER;
BEGIN
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
    END IF;

    SELECT Balance
    INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id
    FOR UPDATE;

    SELECT COUNT(*)
    INTO v_to_exists
    FROM Accounts
    WHERE AccountID = p_to_account_id;

    IF v_to_exists = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Destination account does not exist.');
    END IF;

    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20003, 'Insufficient funds in source account.');
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

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        Log_Error('SafeTransferFunds', 'Source account does not exist.');
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: source account does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        Log_Error('SafeTransferFunds', SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id      IN Employees.EmployeeID%TYPE,
    p_increase_percent IN NUMBER
) AS
    v_rows_updated NUMBER;
BEGIN
    IF p_increase_percent < 0 THEN
        RAISE_APPLICATION_ERROR(-20011, 'Salary increase percentage cannot be negative.');
    END IF;

    UPDATE Employees
    SET Salary = Salary + (Salary * p_increase_percent / 100)
    WHERE EmployeeID = p_employee_id;

    v_rows_updated := SQL%ROWCOUNT;

    IF v_rows_updated = 0 THEN
        RAISE_APPLICATION_ERROR(-20012, 'Employee ID does not exist.');
    END IF;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for employee ' || p_employee_id || '.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        Log_Error('UpdateSalary', SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Salary update failed: ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN Customers.CustomerID%TYPE,
    p_name        IN Customers.Name%TYPE,
    p_dob         IN Customers.DOB%TYPE,
    p_balance     IN Customers.Balance%TYPE
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP, LastModified)
    VALUES (
        p_customer_id,
        p_name,
        p_dob,
        p_balance,
        CASE WHEN p_balance > 10000 THEN 'Y' ELSE 'N' END,
        SYSDATE
    );

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        Log_Error('AddNewCustomer', 'Customer ID already exists: ' || p_customer_id);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer insert failed: duplicate customer ID.');
    WHEN OTHERS THEN
        ROLLBACK;
        Log_Error('AddNewCustomer', SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer insert failed: ' || SQLERRM);
END;
/

BEGIN
    SafeTransferFunds(1, 2, 100);
    UpdateSalary(1, 10);
    AddNewCustomer(4, 'Neha Rao', DATE '1995-04-12', 22000);
END;
/
