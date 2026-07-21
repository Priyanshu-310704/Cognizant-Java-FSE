# Exercise 2: Error Handling

## Scenarios

1. `SafeTransferFunds` transfers money between accounts and rolls back on errors.
2. `UpdateSalary` increases an employee salary and logs missing employee IDs.
3. `AddNewCustomer` inserts a customer and logs duplicate IDs.

## Files

- `solution.sql` - stored procedures with exception handling and logging to `ErrorLog`.

## Run

```sql
@../schema.sql
@solution.sql
```
