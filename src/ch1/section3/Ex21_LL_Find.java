// Write a method find() that takes a linked list and a string key as arguments
// and returns true if some node in the list has key as its item field, false otherwise.

package ch1.section3;

import java.util.List;

public class Ex21_LL_Find<T> {

  private Node head;
  private int size;

  public int size() {
    return size;
  }

  public void pushFront(T item) {
    head = new Node(item, head);
    ++size;
  }

  public boolean find(T key) {
    if (head == null) {
      return false;
    }
    Node current = head;
    while (current != null && !current.data.equals(key)) {
      current = current.next;
    }
    return current != null;
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

class Ex21_Helper {

  public static <T> Ex21_LL_Find<T> buildLinkedList(List<T> list) {
    Ex21_LL_Find<T> ll = new Ex21_LL_Find<>();
    for (T obj : list) {
      ll.pushFront(obj);
    }
    return ll;
  }
}
