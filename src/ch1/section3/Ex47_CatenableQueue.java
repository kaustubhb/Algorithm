// Catenable Queue. Add an extra operation catenation that (destructively)
// concatenates two queues.

package ch1.section3;

import java.util.Iterator;

public class Ex47_CatenableQueue<T> implements Iterable<T> {

  private int sz = 0;
  private Node<T> tail = null;

  public Ex47_CatenableQueue() {
  }

  // Neither q1 nor q2 are safe to use after this operation.
  public static <T> Ex47_CatenableQueue<T> catenateQueues(Ex47_CatenableQueue<T> q1,
      Ex47_CatenableQueue<T> q2) {
    if (q1.tail == null) {
      return q2;
    }
    if (q2.tail == null) {
      return q1;
    }
    Node<T> temp = q1.tail.next;
    q1.tail.next = q2.tail.next;
    q2.tail.next = temp;
    q2.sz += q1.sz;
    q1.tail = null;
    q1.sz = 0;
    return q2;
  }

  public boolean isEmpty() {
    return tail == null;
  }

  public int size() {
    return sz;
  }

  public void enqueue(T it) {
    Node<T> t = new Node<>();
    t.T = it;
    if (tail == null) {
      tail = t;
      tail.next = tail;
    } else {
      Node<T> temp = tail.next;
      tail.next = t;
      t.next = temp;
      tail = t;
    }
    ++sz;
  }

  public T dequeue() {
    if (tail == null) {
      throw new RuntimeException();
    }
    --sz;
    if (tail.next == tail) {
      T it = tail.T;
      tail = null;
      return it;
    }
    Node<T> t = tail.next;
    tail.next = t.next;
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
        t = tail.next;
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
