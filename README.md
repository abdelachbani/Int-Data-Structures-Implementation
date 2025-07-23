# Integer Data Structures Implementation

A Java implementation of efficient data structures for integer values. More data structures may be added in the future.
This is done for educational purposes and to provide a foundation for more complex data manipulation tasks.

## Overview

This project provides specialized data structures for working with integer values. The implementations use linked lists as the underlying storage mechanism, offering efficient memory usage and flexible operations.

## Data Structures

### NodeInt

A basic node class that serves as the building block for the linked data structures. Each node contains:
- An integer data value
- A reference to the next node

### QueueIntLinked

A queue implementation for integers using a linked list. Follows the FIFO (First-In-First-Out) principle.

**Basic Operations:**
- `add(int x)`: Adds an element to the end of the queue
- `remove()`: Removes and returns the element at the front of the queue
- `element()`: Returns the element at the front without removing it
- `empty()`: Checks if the queue is empty
- `size()`: Returns the number of elements in the queue

**Advanced Operations:**
- `cut(int n)`: Keeps the first n elements and returns a new queue with the remaining elements
- `mirrorize()`: Adds a mirror image of the queue to itself
- `reverse()`: Reverses the order of elements
- `swapThirds()`: Divides the queue into three parts and rearranges them
- `removeRepeatedValues()`: Removes duplicate values
- `addSorted(int d)`: Adds an element in sorted order
- `split(int x)`: Splits the queue based on a value x

### StackIntLinked

A stack implementation for integers using a linked list. Follows the LIFO (Last-In-First-Out) principle.

**Basic Operations:**
- `push(int x)`: Adds an element to the top of the stack
- `pop()`: Removes and returns the element at the top of the stack
- `peek()`: Returns the element at the top without removing it
- `empty()`: Checks if the stack is empty
- `size()`: Returns the number of elements in the stack

**Advanced Operations:**
- `get(int i)`: Returns the element at the specified position
- `topBase()`: Moves the bottom element to the top and sets its value to the original top value
- `pushR(int x)`: Pushes an element after its last occurrence in the stack

## Usage

### Creating a Queue

```java
QueueIntLinked queue = new QueueIntLinked();
queue.add(1);
queue.add(2);
queue.add(3);
```

### Creating a Stack

```java
StackIntLinked stack = new StackIntLinked();
stack.push(1);
stack.push(2);
stack.push(3);
```

## Features

- Efficient memory usage with linked list implementation
- Comprehensive set of operations beyond standard interfaces
- Specialized for integer values
- Advanced manipulation methods for complex data operations