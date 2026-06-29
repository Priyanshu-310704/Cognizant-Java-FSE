# Exercise 3: Builder Pattern

## Scenario

A system needs to create complex `Computer` objects with many optional parts.

## Pattern Used

The Builder Pattern separates object construction from object representation. It is useful when an object has many optional fields.

## Implementation

- `Computer` has a private constructor.
- `Computer.Builder` is a static nested builder class.
- Builder methods return `this`, allowing method chaining.
- `build()` returns the final `Computer` object.

## Benefits

- Avoids long constructors with many parameters
- Improves readability
- Makes optional configuration easier

## Run

```powershell
javac *.java
java BuilderPatternExample
```
