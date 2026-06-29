# Exercise 6: Library Management System

## Scenario

A library system needs to search books by title or author. This implementation focuses on searching by title.

## Concepts Used

- Linear search
- Binary search
- Sorted arrays
- Case-insensitive string comparison

## Linear Search

Linear search checks each book one by one until the title is found.

Time complexity:

- Best case: `O(1)`
- Average case: `O(n)`
- Worst case: `O(n)`

## Binary Search

Binary search works only when books are sorted by title. It checks the middle item and removes half of the search space in every step.

Time complexity:

- Best case: `O(1)`
- Average case: `O(log n)`
- Worst case: `O(log n)`

## When to Use Which

Use linear search when:

- The list is small
- The list is unsorted
- Sorting cost is not worth it

Use binary search when:

- The list is large
- The list is already sorted or can remain sorted
- Many search operations are expected

## Run

```powershell
javac *.java
java LibrarySearchDemo
```
