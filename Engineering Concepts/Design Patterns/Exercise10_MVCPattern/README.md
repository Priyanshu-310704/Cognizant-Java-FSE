# Exercise 10: MVC Pattern

## Scenario

A simple application manages student records using the MVC design pattern.

## Pattern Used

MVC separates an application into three parts:

- Model: stores data
- View: displays data
- Controller: connects model and view

## Implementation

- `Student` is the model.
- `StudentView` displays student details.
- `StudentController` updates the model and refreshes the view.

## Benefits

- Separates responsibilities
- Makes code easier to maintain
- Helps UI and business logic evolve independently

## Run

```powershell
javac *.java
java MVCPatternExample
```
