# Exercise 5: Triggers

## Scenarios

1. `trg_update_customer_last_modified` updates `LastModified` before customer changes.
2. `trg_log_transaction` writes an audit entry for every inserted transaction.
3. `trg_check_transaction_rules` blocks invalid deposits and withdrawals.

## Files

- `solution.sql` - trigger definitions and small demo statements.

## Run

```sql
@../schema.sql
@solution.sql
```
