Q. Add a method peek() to Stack that returns the most recently inserted
item on the stack (without popping it).

A.
```
public Item peek() {
if (isEmpty()) {
  throw new RuntimeException("Trying to peek an empty stack.");
}
return head.item;
}
```