package ch1.section3;

import java.util.Iterator;
import java.util.List;

public class LinkedList<T> implements Iterable<T> {

  private Node head, tail;
  private int size;

  public void pushFront(T item) {
    head = new Node(item, head);
    ++size;
    if (size == 1) {
      tail = head;
    }
  }

  public void pushBack(T item) {
    Node n = new Node(item, null);
    if (tail != null) {
      tail.next = n;
    }
    tail = n;
    if (head == null) {
      head = tail;
    }
    ++size;

  }

  public T removeFront() {
    if (size == 0) {
      throw new RuntimeException("Cannot remove front from empty linked list.");
    }
    --size;
    if (size == 0) {
      tail = null;
    }
    T temp = head.data;
    head = head.next;
    return temp;
  }


  public int size() {
    return size;
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
      sb.append(current.data).append(", ");
      current = current.next;
    }
    sb.append(current.data).append("]");
    return sb.toString();
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  public class Node {

    T data;
    Node next;

    public Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private class LinkedListIterator implements Iterator<T> {

    Node current = head;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new RuntimeException("Called next() when hasNext() is false");
      }
      Node temp = current;
      current = current.next;
      return temp.data;
    }
  }
}

class LinkedListHelper {

  public static <T> LinkedList<T> buildLinkedList(List<T> list) {
    LinkedList<T> ll = new LinkedList<>();
    for (T obj : list) {
      ll.pushFront(obj);
    }
    return ll;
  }
}

