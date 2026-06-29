# Exercise 5: Decorator Pattern

## Scenario

A notification system should support multiple channels such as Email, SMS, and Slack dynamically.

## Pattern Used

The Decorator Pattern adds new behavior to an object without modifying the original class.

## Implementation

- `Notifier` is the component interface.
- `EmailNotifier` is the base concrete component.
- `NotifierDecorator` stores a wrapped `Notifier`.
- `SMSNotifierDecorator` and `SlackNotifierDecorator` add extra sending behavior.

## Benefits

- Adds features dynamically
- Avoids creating many subclasses for every channel combination
- Follows open-closed principle

## Run

```powershell
javac *.java
java DecoratorPatternExample
```
