// Write a method remove() that takes a linked list and a string key as arguments
// and removes all of the nodes in the list that have key as its item field.

package ch1.section3;

import java.util.List;

public class Ex26_LL_Remove<T> {

  private Node head;
  private int size;

  public int size() {
    return size;
  }

  public void pushFront(T item) {
    head = new Node(item, head);
    ++size;
  }

  public void remove(T key) {
    if (head == null) {
      return;
    }
    while (head.data.equals(key)) {
      head = head.next;
      --size;
    }
    Node current = head;
    while (current.next != null) {
      if (current.next.data.equals(key)) {
        current.next = current.next.next;
        --size;
      } else {
        current = current.next;
      }
    }
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

class Ex26_Helper {

  public static <T> Ex26_LL_Remove<T> buildLinkedList(List<T> list) {
    Ex26_LL_Remove<T> ll = new Ex26_LL_Remove<>();
    for (T obj : list) {
      ll.pushFront(obj);
    }
    return ll;
  }
}
