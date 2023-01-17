// Catenable Stack. Add an extra operation catenation that (destructively)
// concatenates two stacks.

package ch1.section3;

import java.util.Iterator;

public class Ex47_CatenableStack<T> implements Iterable<T> {

  private int sz = 0;
  private Node<T> last = null;

  public Ex47_CatenableStack() {
  }

  // Neither q1 nor q2 are safe to use after this operation.
  public static <T> Ex47_CatenableStack<T> catenateStacks(Ex47_CatenableStack<T> stack1,
      Ex47_CatenableStack<T> stack2) {
    if (stack1.last == null) {
      return stack2;
    }
    if (stack2.last == null) {
      return stack1;
    }
    Node<T> temp = stack1.last.next;
    stack1.last.next = stack2.last.next;
    stack2.last.next = temp;
    stack2.sz += stack1.sz;
    stack1.last = null;
    stack1.sz = 0;
    return stack2;
  }

  public boolean isEmpty() {
    return last == null;
  }

  public int size() {
    return sz;
  }

  public void push(T it) {
    Node<T> t = new Node<>();
    t.T = it;
    if (last == null) {
      last = t;
      last.next = last;
    } else {
      Node<T> temp = last.next;
      last.next = t;
      t.next = temp;
    }
    ++sz;
  }

  public T pop() {
    if (last == null) {
      throw new RuntimeException("Trying to pop from an empty stack");
    }
    --sz;
    if (last.next == last) {
      T it = last.T;
      last = null;
      return it;
    }
    Node<T> t = last.next;
    last.next = t.next;
    return t.T;
  }

  public Iterator<T> iterator() {
    return new CircularQueueIterator();
  }

  private static class Node<T> {

    T T;
    Node next;
  }

  private class CircularQueueIterator implements Iterator<T> {

    Node t;
    int count;

    public CircularQueueIterator() {
      count = size();
      if (count > 0) {
        t = last.next;
      }
    }

    public boolean hasNext() {
      return count > 0;
    }

    public T next() {
      if (!hasNext()) {
        throw new RuntimeException();
      }
      T it = (T) t.T;
      t = t.next;
      --count;
      return it;
    }
  }
}
