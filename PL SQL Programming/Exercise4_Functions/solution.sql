SET SERVEROUTPUT ON

CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER AS
BEGIN
    RETURN TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
END;
/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount       IN NUMBER,
    p_annual_rate       IN NUMBER,
    p_duration_in_years IN NUMBER
) RETURN NUMBER AS
    v_monthly_rate NUMBER;
    v_months NUMBER;
    v_installment NUMBER;
BEGIN
    IF p_loan_amount <= 0 OR p_duration_in_years <= 0 THEN
        RAISE_APPLICATION_ERROR(-20201, 'Loan amount and duration must be greater than zero.');
    END IF;

    v_months := p_duration_in_years * 12;
    v_monthly_rate := p_annual_rate / 12 / 100;

    IF v_monthly_rate = 0 THEN
        v_installment := p_loan_amount / v_months;
    ELSE
        v_installment :=
            p_loan_amount *
            v_monthly_rate *
            POWER(1 + v_monthly_rate, v_months) /
            (POWER(1 + v_monthly_rate, v_months) - 1);
    END IF;

    RETURN ROUND(v_installment, 2);
END;
/

CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN Accounts.AccountID%TYPE,
    p_amount     IN NUMBER
) RETURN BOOLEAN AS
    v_balance Accounts.Balance%TYPE;
BEGIN
    IF p_amount < 0 THEN
        RETURN FALSE;
    END IF;

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/

DECLARE
    v_has_balance BOOLEAN;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Age for 1985-05-15: ' || CalculateAge(DATE '1985-05-15'));
    DBMS_OUTPUT.PUT_LINE('Monthly installment: ' || CalculateMonthlyInstallment(500000, 8.5, 5));

    v_has_balance := HasSufficientBalance(1, 500);

    IF v_has_balance THEN
        DBMS_OUTPUT.PUT_LINE('Account 1 has sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Account 1 does not have sufficient balance.');
    END IF;
END;
/
