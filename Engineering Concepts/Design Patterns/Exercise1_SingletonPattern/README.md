# Exercise 1: Singleton Pattern

## Scenario

An application needs one common logging utility throughout its lifecycle.

## Pattern Used

The Singleton Pattern ensures that only one object of a class is created and provides a global access point to that object.

## Implementation

- `Logger` has a private static instance.
- `Logger` constructor is private.
- `getInstance()` creates the object only once and returns the same object every time.

## Benefits

- Controlled object creation
- Shared logging behavior
- Avoids multiple logger instances

## Run

```powershell
javac *.java
java SingletonPatternExample
```
