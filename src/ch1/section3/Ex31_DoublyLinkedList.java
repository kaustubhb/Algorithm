/* Implement a nested class DoubleNode for building doubly-linked lists, where
 * each node contains a reference to the item preceding it and the item following it in the
 * list (null if there is no such item). Then implement static methods for the following tasks:
 * insert at the beginning, insert at the end, remove from the beginning, remove from the end,
 * insert before a given node, insert after a given node, and remove a given node.
 */

package ch1.section3;

import java.util.Iterator;

public class Ex31_DoublyLinkedList<Item> implements Iterable<Item> {

  private DoubleNode<Item> head = null, tail = null;
  private int sz = 0;

  public void removeNode(DoubleNode<Item> dn) {
    if (dn == head) {
      removeFront();
    } else if (dn == tail) {
      removeEnd();
    } else {
      dn.prev.next = dn.next;
      dn.next.prev = dn.prev;
      --sz;
    }
  }

  public DoubleNode<Item> getNodeAt(int index) {
    if (index < 0 || index >= size()) {
      throw new RuntimeException();
    }
    DoubleNode<Item> dn = head;
    while (index != 0) {
      dn = dn.next;
      --index;
    }
    return dn;
  }

  public boolean isValid() {
    Stack<Item> st = new Stack<>();
    for (Item t : forEachForward()) {
      st.push(t);
    }
    for (Item t : forEachReverse()) {
      Item x = st.pop();
      if (x != t) {
        return false;
      }
    }
    return true;
  }

  public void insertAfter(DoubleNode<Item> dn, Item item) {
    if (dn == null) {
      insertBefore(head, item);
    } else {
      insertBefore(dn.next, item);
    }
  }

  public void insertBefore(DoubleNode<Item> dn, Item item) {
    if (dn == null) {
      insertEnd(item);
      return;
    }
    DoubleNode<Item> node = new DoubleNode<>();
    node.item = item;
    DoubleNode<Item> t = head;
    while (t != dn) {
      t = t.next;
    }
    DoubleNode<Item> prev = t.prev;
    t.prev = node;
    node.prev = prev;
    node.next = t;
    if (prev != null) {
      prev.next = node;
    } else {
      head = node;
    }
    ++sz;
  }

  public Item removeEnd() {
    if (size() == 0) {
      throw new RuntimeException();
    }
    --sz;
    DoubleNode<Item> dn = tail;
    tail = tail.prev;
    if (tail != null) {
      tail.next = null;
    } else {
      head = null;
    }
    dn.prev = null;
    return dn.item;
  }

  public Item removeFront() {
    if (size() == 0) {
      throw new RuntimeException("Attempt to remove from empty list");
    }
    --sz;
    DoubleNode<Item> temp = head;
    head = head.next;
    if (head != null) {
      head.prev = null;
    } else {
      tail = null;
    }
    temp.next = null;
    return temp.item;
  }

  public void insertEnd(Item item) {
    DoubleNode<Item> node = new DoubleNode<>();
    node.item = item;

    if (head == null) {
      head = tail = node;
    } else {
      node.prev = tail;
      tail.next = node;
      tail = node;
    }
    ++sz;
  }

  public void insertFront(Item it) {
    DoubleNode<Item> node = new DoubleNode<>();
    node.item = it;

    if (head == null) {
      head = tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
    sz++;
  }

  public int size() {
    return sz;
  }

  public boolean isEmpty() {
    return sz == 0;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[[");
    DoubleNode<Item> temp = head;
    if (temp == null) {
      return "[[]]";
    }
    while (temp.next != null) {
      result.append(temp.item.toString()).append("-");
      temp = temp.next;
    }
    result.append(temp.item.toString()).append("]]");
    return result.toString();
  }

  public Iterator<Item> iterator() {
    return new ForwardListIterator();
  }

  public Iterable<Item> forEachForward() {
    // declaring an anonymous iterable class
    return ForwardListIterator::new;
  }

  public Iterable<Item> forEachReverse() {
    return ReverseListIterator::new;
  }

  static class DoubleNode<T> {

    T item;
    DoubleNode<T> next = null, prev = null;
  }

  private class ForwardListIterator implements Iterator<Item> {

    DoubleNode<Item> dn = head;

    @Override
    public boolean hasNext() {
      return dn != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new RuntimeException();
      }
      Item it = dn.item;
      dn = dn.next;
      return it;
    }
  }

  private class ReverseListIterator implements Iterator<Item> {

    DoubleNode<Item> dn = tail;

    public boolean hasNext() {
      return dn != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new RuntimeException();
      }
      Item it = dn.item;
      dn = dn.prev;
      return it;
    }
  }
}
