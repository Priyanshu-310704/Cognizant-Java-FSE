# Exercise 4: Adapter Pattern

## Scenario

A payment processing system must integrate with multiple third-party gateways that expose different method names.

## Pattern Used

The Adapter Pattern allows incompatible interfaces to work together by wrapping one interface and exposing another expected interface.

## Implementation

- `PaymentProcessor` is the target interface used by the application.
- `StripeGateway` and `RazorpayGateway` are third-party gateway classes.
- `StripeAdapter` and `RazorpayAdapter` convert gateway-specific calls into `processPayment()`.

## Benefits

- Keeps application code independent of third-party interfaces
- Makes gateway replacement easier
- Supports integration with incompatible APIs

## Run

```powershell
javac *.java
java AdapterPatternExample
```
