// Fail-fast iterator. Modify the iterator code in Stack to immediately throw a
// java.util.ConcurrentModificationException if the client modifies the collection
// (via push() or pop()) during iteration? b).

package ch1.section3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Ex50_FailFastStack<Item> implements Iterable<Item> {

  private Node head;
  private int sz = 0;
  private int modCount = 0;

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    return sz;
  }

  public void push(Item it) {
    ++modCount;
    Node temp = new Node();
    temp.item = it;
    temp.next = head;
    head = temp;
    ++sz;
  }

  public Item pop() {
    ++modCount;
    if (isEmpty()) {
      throw new RuntimeException("Trying to pop from an empty stack");
    }
    Item it = head.item;
    head = head.next;
    --sz;
    return it;
  }

  @Override
  public String toString() {
    Node current = head;
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    if (current == null) {
      sb.append("]");
      return sb.toString();
    }
    while (current.next != null) {
      sb.append(current.item).append(", ");
      current = current.next;
    }
    sb.append(current.item).append("]");
    return sb.toString();
  }

  @Override
  public Iterator<Item> iterator() {
    return new ReverseIterator();
  }

  private class Node {

    Item item;
    Node next;
  }

  private class ReverseIterator implements Iterator<Item> {

    private final int countModifications;
    Node n = head;

    public ReverseIterator() {
      countModifications = modCount;
    }

    @Override
    public boolean hasNext() {
      return n != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new RuntimeException("No more elements.");
      }
      if (modCount != countModifications) {
        throw new ConcurrentModificationException("Stack was modified during iteration");
      }
      Item temp = n.item;
      n = n.next;
      return temp;
    }
  }
}
