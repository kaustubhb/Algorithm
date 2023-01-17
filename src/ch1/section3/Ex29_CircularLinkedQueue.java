/* Write a Queue implementation that uses a circular linked list, which is the same
 * as a linked list except that no links are null and the value of last.next is first whenever
 * the list is not empty. Keep only one Node instance variable (last).
 */

package ch1.section3;

import java.util.Iterator;

public class Ex29_CircularLinkedQueue<Item> implements Iterable<Item> {
  private class Node {
    Item item;
    Node next;
  }

  private int sz = 0;
  private Node tail = null;

  public boolean isEmpty() {
    return tail == null;
  }

  public int size() {
    return sz;
  }

  public void enqueue(Item it) {
    Node t = new Node();
    t.item = it;
    if (tail == null) {
      tail = t;
      tail.next = tail;
    } else {
      Node temp = tail.next;
      tail.next = t;
      t.next = temp;
      tail = t;
    }
    ++sz;
  }

  public Item dequeue() {
    if (tail == null) {
      throw new RuntimeException();
    }
    --sz;
    if (tail.next == tail) {
      Item it = tail.item;
      tail = null;
      return it;
    }
    Node t = tail.next;
    tail.next = t.next;
    return t.item;
  }

  public Iterator<Item> iterator() {
    return new CircularQueueIterator();
  }

  private class CircularQueueIterator implements Iterator<Item> {
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

    public Item next() {
      if (!hasNext()) {
        throw new RuntimeException();
      }
      Item it = t.item;
      t = t.next;
      --count;
      return it;
    }
  }
}
