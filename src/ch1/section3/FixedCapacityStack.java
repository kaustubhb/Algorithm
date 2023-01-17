package ch1.section3;

public class FixedCapacityStack<Item> {

  private final Item[] stack;
  private int top;

  public FixedCapacityStack(int cap) {
    stack = (Item[]) new Object[cap];
    top = 0;
  }

  public boolean isEmpty() {
    return top == 0;
  }

  // Ex 1.3.1 Add a method isFull() to FixedCapacityStackOfStrings.
  public boolean isFull() {
    return top == stack.length;
  }

  public void push(Item item) {
    if (top == stack.length) {
      throw new RuntimeException("Stack overflow");
    }
    stack[top++] = item;
  }

  public Item pop() {
    if (top == 0) {
      throw new RuntimeException("Stack Underflow");
    }
    Item temp = stack[--top];
    stack[top] = null;
    return temp;
  }

  int size() {
    return top;
  }
}