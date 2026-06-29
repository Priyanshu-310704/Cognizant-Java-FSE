# Exercise 6: Proxy Pattern

## Scenario

An image viewer loads images from a remote server. Loading should happen only when the image is actually displayed.

## Pattern Used

The Proxy Pattern provides a placeholder object that controls access to a real object.

## Implementation

- `Image` is the subject interface.
- `RealImage` loads and displays the image.
- `ProxyImage` stores the file name and creates `RealImage` only during the first display call.
- Later calls reuse the cached `RealImage`.

## Benefits

- Supports lazy initialization
- Saves resources
- Adds caching without changing the real subject class

## Run

```powershell
javac *.java
java ProxyPatternExample
```
