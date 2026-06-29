# Exercise 7: Observer Pattern

## Scenario

A stock market monitoring app must notify multiple clients whenever stock prices change.

## Pattern Used

The Observer Pattern defines a one-to-many dependency. When the subject changes, all registered observers are notified.

## Implementation

- `Stock` is the subject interface.
- `StockMarket` stores observers and stock data.
- `Observer` is the observer interface.
- `MobileApp` and `WebApp` receive updates.

## Benefits

- Supports automatic notifications
- Loosely couples subject and observers
- Allows observers to be added or removed dynamically

## Run

```powershell
javac *.java
java ObserverPatternExample
```
