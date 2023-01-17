// Write a method max() that takes a reference to the first node in a linked list as
// argument and returns the value of the maximum key in the list. Assume that all keys are
// positive integers, and return 0 if the list is empty.

package ch1.section3;

import java.util.List;

public class Ex27_LL_Max<T extends Comparable<T>> {

  private Node head;
  private int size;

  public int size() {
    return size;
  }

  public void pushFront(T item) {
    head = new Node(item, head);
    ++size;
  }

  public T max(Node first) {
    if (first == null) {
      throw new IllegalArgumentException("first node cannot be null");
    }
    T maxVal = first.data;
    first = first.next;
    while (first != null) {
      if (first.data.compareTo(maxVal) > 0) {
        maxVal = first.data;
      }
      first = first.next;
    }
    return maxVal;
  }

  // k -> [0, size)
  public Node getNodeAt(int k) {
    if (k < 0 || k >= size()) {
      throw new IllegalArgumentException("Invalid index for node.");
    }
    Node current = head;
    int i = 0;
    while (i++ < k) {
      current = current.next;
    }
    return current;
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

  public class Node {

    T data;
    Node next;

    public Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}

class Ex27_Helper {

  public static <T extends Comparable<T>> Ex27_LL_Max<T> buildLinkedList(List<T> list) {
    Ex27_LL_Max<T> ll = new Ex27_LL_Max<>();
    for (T obj : list) {
      ll.pushFront(obj);
    }
    return ll;
  }
}
