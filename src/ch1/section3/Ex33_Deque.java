/* Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
 *	a queue but supports adding and removing items at both ends.
 * Write a class Deque_33 that uses a doubly-linked list to implement this API and a class
 * ResizingArrayDeque that uses a resizing array
 */

package ch1.section3;

import java.util.Iterator;

public class Ex33_Deque<Item> implements Iterable<Item> {

  private final Ex31_DoublyLinkedList<Item> dll = new Ex31_DoublyLinkedList<>();

  public boolean isEmpty() {
    return dll.isEmpty();
  }

  public int size() {
    return dll.size();
  }

  public void pushLeft(Item item) {
    dll.insertFront(item);
  }

  public void pushRight(Item item) {
    dll.insertEnd(item);
  }

  public Item popLeft() {
    return dll.removeFront();
  }

  public Item popRight() {
    return dll.removeEnd();
  }

  public Iterable<Item> forEachForward() {
    return dll.forEachForward();
  }

  public Iterable<Item> forEachReverse() {
    return dll.forEachReverse();
  }

  public String toString() {
    return "Ex33_Deque:" + dll;
  }

  boolean isValid() {
    return dll.isValid();
  }

  @Override
  public Iterator<Item> iterator() {
    return forEachForward().iterator();
  }
}
