package ch1.section3;

import java.util.Iterator;

// Linked list based implementation
public class Stack<Item> implements Iterable<Item> {

  private Node head;
  private int sz = 0;

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    return sz;
  }

  public Item peek() {
    if (isEmpty()) {
      throw new RuntimeException("Trying to peek an empty stack.");
    }
    return head.item;
  }

  public void push(Item it) {
    Node temp = new Node();
    temp.item = it;
    temp.next = head;
    head = temp;
    ++sz;
  }

  public Item pop() {
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

    Node n = head;

    @Override
    public boolean hasNext() {
      return n != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new RuntimeException("No more elements.");
      }
      Item temp = n.item;
      n = n.next;
      return temp;
    }
  }
}
