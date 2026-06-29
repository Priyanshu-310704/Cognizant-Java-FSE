# Exercise 3: Sorting Customer Orders

## Scenario

Customer orders need to be sorted by `totalPrice` so high-value or low-value orders can be analyzed easily.

## Concepts Used

- Sorting objects by a field
- Bubble sort
- Quick sort
- Time complexity comparison

## Sorting Algorithms

### Bubble Sort

Bubble sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

Time complexity:

- Best case: `O(n)` when optimized and already sorted
- Average case: `O(n^2)`
- Worst case: `O(n^2)`

### Quick Sort

Quick sort selects a pivot, partitions the array around the pivot, and recursively sorts the partitions.

Time complexity:

- Best case: `O(n log n)`
- Average case: `O(n log n)`
- Worst case: `O(n^2)` when partitioning is highly unbalanced

## Why Quick Sort Is Preferred

Quick sort is generally preferred over bubble sort because it is much faster for large data sets on average. Bubble sort is mainly useful for learning sorting logic.

## Run

```powershell
javac *.java
java SortDemo
```
