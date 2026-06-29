# Exercise 4: Employee Management System

## Scenario

A company needs to manage employee records using arrays.

## Concepts Used

- Array representation in memory
- Fixed-size storage
- Traversal
- Searching
- Deletion by shifting elements

## Array Representation

An array stores elements in contiguous memory locations. This allows fast index-based access.

Advantages:

- Simple to use
- Fast access by index: `O(1)`
- Good when the maximum number of elements is known

Limitations:

- Fixed size
- Insertion and deletion can require shifting
- Searching unsorted data takes linear time

## Operations

| Operation | Time Complexity |
| --- | --- |
| Add at end | `O(1)` if space is available |
| Search by ID | `O(n)` |
| Traverse | `O(n)` |
| Delete by ID | `O(n)` because search and shifting may be needed |

## When to Use Arrays

Arrays are useful when the collection size is fixed or mostly stable, and fast index access is important.

## Run

```powershell
javac *.java
java EmployeeArrayManager
```
