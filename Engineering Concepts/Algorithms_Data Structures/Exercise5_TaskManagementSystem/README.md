# Exercise 5: Task Management System

## Scenario

A task management system needs to add, delete, search, and traverse tasks dynamically.

## Concepts Used

- Singly linked list
- Node structure
- Dynamic memory usage
- Traversal
- Search and delete operations

## Linked List Types

### Singly Linked List

Each node stores data and a reference to the next node.

### Doubly Linked List

Each node stores data, a reference to the next node, and a reference to the previous node.

## Implementation

This solution uses a singly linked list.

Each node stores:

- `Task task`
- `Node next`

## Operations

| Operation | Time Complexity |
| --- | --- |
| Add at end | `O(n)` |
| Search | `O(n)` |
| Traverse | `O(n)` |
| Delete by ID | `O(n)` |

## Advantages Over Arrays

Linked lists are dynamic. They do not need a fixed capacity at creation time. Insertion and deletion are easier when the node position is already known because shifting is not required.

Arrays are better when index-based access is needed frequently.

## Run

```powershell
javac *.java
java TaskLinkedList
```
