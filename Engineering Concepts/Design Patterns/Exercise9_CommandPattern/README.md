# Exercise 9: Command Pattern

## Scenario

A home automation system needs commands to turn devices on or off.

## Pattern Used

The Command Pattern encapsulates a request as an object. This separates the object that invokes the command from the object that performs the action.

## Implementation

- `Command` declares `execute()`.
- `Light` is the receiver.
- `LightOnCommand` and `LightOffCommand` are concrete commands.
- `RemoteControl` is the invoker.

## Benefits

- Decouples invoker and receiver
- Makes commands reusable
- Supports features like undo, queues, and logs in larger systems

## Run

```powershell
javac *.java
java CommandPatternExample
```
