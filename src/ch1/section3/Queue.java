package ch1.section3;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

  private Node head, last;
  private int count = 0;

  public boolean isEmpty() {
    return count == 0;
  }

  public int size() {
    return count;
  }

  public void enqueue(Item it) {
    Node n = new Node();
    n.item = it;
    if (last != null) {
      last.next = n;
    } else {
      head = n;
    }
    last = n;
    ++count;
  }

  public Item dequeue() {
    if (head == null) {
      throw new RuntimeException();
    }
    --count;
    Node temp = head;
    head = head.next;
    if (isEmpty()) {
      last = null;
    }
    return temp.item;
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
    return new ListIterator();
  }

  private class Node {

    Item item;
    Node next;
  }

  private class ListIterator implements Iterator<Item> {

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
      Item it = n.item;
      n = n.next;
      return it;
    }
  }
}
