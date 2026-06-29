# Exercise 2: Factory Method Pattern

## Scenario

A document management system needs to create different documents such as Word, PDF, and Excel without tightly coupling client code to concrete classes.

## Pattern Used

The Factory Method Pattern defines a method for creating objects, while subclasses decide which concrete object to create.

## Implementation

- `Document` is the common interface.
- `WordDocument`, `PdfDocument`, and `ExcelDocument` are concrete products.
- `DocumentFactory` declares the factory method `createDocument()`.
- Concrete factories create specific document objects.

## Benefits

- Reduces direct dependency on concrete classes
- Makes adding new document types easier
- Keeps object creation logic separate

## Run

```powershell
javac *.java
java FactoryMethodPatternExample
```
