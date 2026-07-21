SET SERVEROUTPUT ON

BEGIN
    EXECUTE IMMEDIATE 'DROP TRIGGER trg_check_transaction_rules';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -4080 THEN RAISE; END IF;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TRIGGER trg_log_transaction';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -4080 THEN RAISE; END IF;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TRIGGER trg_update_customer_last_modified';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -4080 THEN RAISE; END IF;
END;
/

BEGIN
    FOR obj IN (
        SELECT object_name, object_type
        FROM user_objects
        WHERE object_name IN (
            'CUSTOMERMANAGEMENT',
            'EMPLOYEEMANAGEMENT',
            'ACCOUNTOPERATIONS',
            'SAFETRANSFERFUNDS',
            'UPDATESALARY',
            'ADDNEWCUSTOMER',
            'PROCESSMONTHLYINTEREST',
            'UPDATEEMPLOYEEBONUS',
            'TRANSFERFUNDS',
            'CALCULATEAGE',
            'CALCULATEMONTHLYINSTALLMENT',
            'HASSUFFICIENTBALANCE',
            'LOG_ERROR'
        )
        AND object_type IN ('PACKAGE', 'PROCEDURE', 'FUNCTION')
    ) LOOP
        EXECUTE IMMEDIATE 'DROP ' || obj.object_type || ' ' || obj.object_name;
    END LOOP;
END;
/

BEGIN
    FOR seq IN (
        SELECT sequence_name
        FROM user_sequences
        WHERE sequence_name IN ('TRANSACTION_SEQ', 'AUDIT_LOG_SEQ', 'ERROR_LOG_SEQ')
    ) LOOP
        EXECUTE IMMEDIATE 'DROP SEQUENCE ' || seq.sequence_name;
    END LOOP;
END;
/

BEGIN
    FOR tab IN (
        SELECT table_name
        FROM user_tables
        WHERE table_name IN (
            'ERRORLOG',
            'AUDITLOG',
            'TRANSACTIONS',
            'LOANS',
            'ACCOUNTS',
            'EMPLOYEES',
            'CUSTOMERS'
        )
    ) LOOP
        EXECUTE IMMEDIATE 'DROP TABLE ' || tab.table_name || ' CASCADE CONSTRAINTS PURGE';
    END LOOP;
END;
/

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL,
    DOB DATE NOT NULL,
    Balance NUMBER(12, 2) DEFAULT 0 NOT NULL,
    IsVIP CHAR(1) DEFAULT 'N' CHECK (IsVIP IN ('Y', 'N')),
    LastModified DATE DEFAULT SYSDATE NOT NULL
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER NOT NULL,
    AccountType VARCHAR2(20) NOT NULL,
    Balance NUMBER(12, 2) DEFAULT 0 NOT NULL,
    LastModified DATE DEFAULT SYSDATE NOT NULL,
    CONSTRAINT fk_accounts_customers
        FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER NOT NULL,
    TransactionDate DATE DEFAULT SYSDATE NOT NULL,
    Amount NUMBER(12, 2) NOT NULL,
    TransactionType VARCHAR2(10) NOT NULL,
    CONSTRAINT chk_transaction_type
        CHECK (TransactionType IN ('Deposit', 'Withdrawal')),
    CONSTRAINT fk_transactions_accounts
        FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER NOT NULL,
    LoanAmount NUMBER(12, 2) NOT NULL,
    InterestRate NUMBER(5, 2) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    CONSTRAINT fk_loans_customers
        FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL,
    Position VARCHAR2(50),
    Salary NUMBER(12, 2) NOT NULL,
    Department VARCHAR2(50),
    HireDate DATE
);

CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TableName VARCHAR2(50) NOT NULL,
    Operation VARCHAR2(30) NOT NULL,
    ReferenceID NUMBER,
    Message VARCHAR2(4000),
    CreatedAt DATE DEFAULT SYSDATE NOT NULL
);

CREATE TABLE ErrorLog (
    ErrorID NUMBER PRIMARY KEY,
    ProcedureName VARCHAR2(100) NOT NULL,
    ErrorMessage VARCHAR2(4000) NOT NULL,
    CreatedAt DATE DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE Transaction_Seq START WITH 100 INCREMENT BY 1;
CREATE SEQUENCE Audit_Log_Seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE Error_Log_Seq START WITH 1 INCREMENT BY 1;

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (3, 'Robert King', TO_DATE('1958-11-10', 'YYYY-MM-DD'), 12500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (3, 3, 'Savings', 12500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 3, 15000, 7.5, ADD_MONTHS(SYSDATE, -24), SYSDATE + 20);

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

COMMIT;
