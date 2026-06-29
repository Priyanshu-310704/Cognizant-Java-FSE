# Exercise 1: Inventory Management System

## Scenario

A warehouse needs an inventory system where products can be stored, updated, searched, and deleted efficiently.

## Concepts Used

- Class and object creation
- Encapsulation
- `HashMap`
- CRUD operations
- Time complexity analysis

## Data Structure Choice

This solution uses:

```java
HashMap<Integer, Product>
```

The key is `productId`, and the value is the complete `Product` object.

This is suitable because product IDs are unique and we usually need fast access by ID.

## Operations

| Operation | Method | Average Time Complexity |
| --- | --- | --- |
| Add product | `addProduct` | `O(1)` |
| Search product | `getProduct` | `O(1)` |
| Update product | `updateProduct` | `O(1)` |
| Delete product | `deleteProduct` | `O(1)` |
| Display all products | `displayProducts` | `O(n)` |

## Optimization Discussion

Using a `HashMap` is better than searching through an `ArrayList` when operations are mostly based on `productId`. An `ArrayList` would require `O(n)` search time, while a `HashMap` gives average `O(1)` access.

Worst case for `HashMap` can degrade due to collisions, but Java's `HashMap` handles collisions efficiently.

## Run

```powershell
javac *.java
java InventoryManager
```
