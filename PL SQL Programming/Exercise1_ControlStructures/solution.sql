SET SERVEROUTPUT ON

PROMPT Scenario 1: Apply 1% loan interest discount for customers above 60.

BEGIN
    FOR rec IN (
        SELECT l.LoanID,
               c.CustomerID,
               c.Name,
               TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS AgeInYears,
               l.InterestRate
        FROM Customers c
        JOIN Loans l ON l.CustomerID = c.CustomerID
    ) LOOP
        IF rec.AgeInYears > 60 THEN
            UPDATE Loans
            SET InterestRate = GREATEST(InterestRate - 1, 0)
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount applied to loan ' || rec.LoanID ||
                ' for customer ' || rec.Name ||
                '. Old rate: ' || rec.InterestRate ||
                ', new rate: ' || GREATEST(rec.InterestRate - 1, 0)
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/

PROMPT Scenario 2: Promote high-balance customers to VIP.

BEGIN
    FOR rec IN (
        SELECT CustomerID, Name, Balance
        FROM Customers
    ) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y',
                LastModified = SYSDATE
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(rec.Name || ' promoted to VIP.');
        ELSE
            UPDATE Customers
            SET IsVIP = 'N',
                LastModified = SYSDATE
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

PROMPT Scenario 3: Print reminders for loans due in the next 30 days.

BEGIN
    FOR rec IN (
        SELECT c.CustomerID,
               c.Name,
               l.LoanID,
               l.EndDate,
               TRUNC(l.EndDate - SYSDATE) AS DaysRemaining
        FROM Customers c
        JOIN Loans l ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30
        ORDER BY l.EndDate
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: customer ' || rec.Name ||
            ' has loan ' || rec.LoanID ||
            ' due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') ||
            ' (' || rec.DaysRemaining || ' days remaining).'
        );
    END LOOP;
END;
/
