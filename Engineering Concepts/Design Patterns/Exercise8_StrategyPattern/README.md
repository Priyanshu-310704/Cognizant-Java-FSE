# Exercise 8: Strategy Pattern

## Scenario

A payment system should allow users to select payment methods such as credit card or PayPal at runtime.

## Pattern Used

The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.

## Implementation

- `PaymentStrategy` is the strategy interface.
- `CreditCardPayment` and `PayPalPayment` are concrete strategies.
- `PaymentContext` holds and executes the selected strategy.

## Benefits

- Changes behavior at runtime
- Avoids large conditional blocks
- Makes adding new payment methods easier

## Run

```powershell
javac *.java
java StrategyPatternExample
```
