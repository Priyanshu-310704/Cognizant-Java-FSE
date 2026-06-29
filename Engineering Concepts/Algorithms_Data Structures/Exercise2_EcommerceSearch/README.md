# Exercise 2: E-commerce Platform Search Function

## Scenario

An e-commerce platform needs fast product search. This exercise compares linear search and binary search.

## Concepts Used

- Big O notation
- Best, average, and worst-case analysis
- Linear search
- Binary search
- Sorting before binary search

## Big O Summary

Big O notation describes how an algorithm's running time grows as input size increases.

Examples:

- `O(1)` - constant time
- `O(log n)` - logarithmic time
- `O(n)` - linear time
- `O(n^2)` - quadratic time

## Search Algorithms

### Linear Search

Linear search checks each product one by one.

Time complexity:

- Best case: `O(1)`, product is first
- Average case: `O(n)`
- Worst case: `O(n)`, product is last or absent

### Binary Search

Binary search repeatedly divides the search range into half.

Important condition: the array must be sorted.

Time complexity:

- Best case: `O(1)`, product is at the middle
- Average case: `O(log n)`
- Worst case: `O(log n)`

## Which Is Better?

For a small unsorted product list, linear search is simple.

For a large e-commerce catalog, binary search is better if the data is sorted. In real systems, search engines and indexed databases are even more suitable.

## Run

```powershell
javac *.java
java SearchDemo
```
