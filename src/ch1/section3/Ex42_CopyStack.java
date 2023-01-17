// Copy a stack. Create a new constructor for the linked-list implementation of
// Stack so that
// Stack<Item> t = new Stack<Item>(s);
// makes t a reference to a new and independent copy of the stack s.

package ch1.section3;

public class Ex42_CopyStack {

  public static <T> Stack<T> copyStack(Stack<T> s) {
    Stack<T> newStack = new Stack<>();
    Stack<T> temp = new Stack<>();

    while (!s.isEmpty()) {
      temp.push(s.pop());
    }
    while (!temp.isEmpty()) {
      T item = temp.pop();
      s.push(item);
      newStack.push(item);
    }
    return newStack;
  }
}
