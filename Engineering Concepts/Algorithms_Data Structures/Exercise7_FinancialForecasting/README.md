# Exercise 7: Financial Forecasting

## Scenario

A financial forecasting tool predicts future value based on current value, growth rate, and number of years.

## Concepts Used

- Recursion
- Base case
- Recursive case
- Time complexity
- Iterative optimization

## Recursive Formula

Future value can be calculated as:

```text
futureValue(years) = futureValue(years - 1) * (1 + growthRate)
```

Base case:

```text
if years == 0, return currentValue
```

## Recursive Method

The recursive method reduces the year count by 1 until it reaches 0.

Time complexity:

- `O(n)`, where `n` is the number of years

Space complexity:

- `O(n)` because recursive calls use the call stack

## Optimization

The iterative method avoids recursive call stack usage.

Time complexity:

- `O(n)`

Space complexity:

- `O(1)`

For very large exponents, mathematical formulas or fast exponentiation can further optimize the calculation.

## Run

```powershell
javac *.java
java FinancialForecast
```
