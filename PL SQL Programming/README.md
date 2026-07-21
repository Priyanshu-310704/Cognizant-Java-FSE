# PL SQL Programming Exercises

This folder contains Oracle PL/SQL solutions for all exercises in `PLSQL_Exercises.docx`.

## Structure

- `schema.sql` - base tables, helper columns, support tables, sequences, and sample data.
- `Exercise1_ControlStructures` - anonymous PL/SQL blocks for loops and conditional logic.
- `Exercise2_ErrorHandling` - procedures with exception handling and rollback behavior.
- `Exercise3_StoredProcedures` - stored procedures for interest, bonuses, and transfers.
- `Exercise4_Functions` - reusable PL/SQL functions.
- `Exercise5_Triggers` - row-level triggers for timestamps, audit logs, and validation.
- `Exercise6_Cursors` - explicit cursor examples.
- `Exercise7_Packages` - package specifications and bodies.

## Run Order

Run the setup once before trying the exercise scripts:

```sql
@schema.sql
```

Then run any exercise solution:

```sql
@Exercise1_ControlStructures/solution.sql
```

The scripts are written for Oracle SQL*Plus, SQLcl, SQL Developer, or any Oracle client that supports `/` as a PL/SQL block terminator.

## Notes

- The exercise document asks for `IsVIP`, audit logging, error logging, and generated transaction IDs, so `schema.sql` adds those support objects to the base schema.
- `IsVIP` is stored as `CHAR(1)` with values `Y` and `N`, which is portable across Oracle versions.
- Monetary examples use simple `NUMBER` columns to match the exercise schema.
