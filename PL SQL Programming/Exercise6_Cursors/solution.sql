SET SERVEROUTPUT ON

PROMPT Scenario 1: Generate monthly statements using an explicit cursor.

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID,
               c.Name,
               a.AccountID,
               t.TransactionID,
               t.TransactionDate,
               t.TransactionType,
               t.Amount
        FROM Customers c
        JOIN Accounts a ON a.CustomerID = c.CustomerID
        JOIN Transactions t ON t.AccountID = a.AccountID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
        ORDER BY c.CustomerID, t.TransactionDate, t.TransactionID;

    v_stmt GenerateMonthlyStatements%ROWTYPE;
BEGIN
    OPEN GenerateMonthlyStatements;
    LOOP
        FETCH GenerateMonthlyStatements INTO v_stmt;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || v_stmt.Name ||
            ', Account: ' || v_stmt.AccountID ||
            ', Transaction: ' || v_stmt.TransactionID ||
            ', Date: ' || TO_CHAR(v_stmt.TransactionDate, 'YYYY-MM-DD') ||
            ', Type: ' || v_stmt.TransactionType ||
            ', Amount: ' || v_stmt.Amount
        );
    END LOOP;
    CLOSE GenerateMonthlyStatements;
END;
/

PROMPT Scenario 2: Apply annual fee using an explicit cursor.

DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;

    v_account ApplyAnnualFee%ROWTYPE;
    v_annual_fee CONSTANT NUMBER := 100;
BEGIN
    OPEN ApplyAnnualFee;
    LOOP
        FETCH ApplyAnnualFee INTO v_account;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = GREATEST(Balance - v_annual_fee, 0),
            LastModified = SYSDATE
        WHERE CURRENT OF ApplyAnnualFee;

        DBMS_OUTPUT.PUT_LINE('Annual fee applied to account ' || v_account.AccountID || '.');
    END LOOP;
    CLOSE ApplyAnnualFee;

    COMMIT;
END;
/

PROMPT Scenario 3: Update loan interest rates using an explicit cursor.

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans
        FOR UPDATE;

    v_loan UpdateLoanInterestRates%ROWTYPE;
    v_new_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN UpdateLoanInterestRates;
    LOOP
        FETCH UpdateLoanInterestRates INTO v_loan;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        IF v_loan.LoanAmount >= 10000 THEN
            v_new_rate := v_loan.InterestRate + 0.50;
        ELSE
            v_new_rate := v_loan.InterestRate + 0.25;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE(
            'Loan ' || v_loan.LoanID ||
            ' rate changed from ' || v_loan.InterestRate ||
            ' to ' || v_new_rate
        );
    END LOOP;
    CLOSE UpdateLoanInterestRates;

    COMMIT;
END;
/
