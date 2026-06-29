# Exercise 11: Dependency Injection

## Scenario

A customer management application has a service class that depends on a repository class.

## Principle Used

Dependency Injection means providing dependencies from outside instead of creating them directly inside the class.

## Implementation

- `CustomerRepository` is the abstraction.
- `CustomerRepositoryImpl` is the concrete implementation.
- `CustomerService` receives `CustomerRepository` through its constructor.

## Benefits

- Reduces tight coupling
- Makes testing easier
- Allows repository implementation to be changed without changing service logic

## Run

```powershell
javac *.java
java DependencyInjectionExample
```
