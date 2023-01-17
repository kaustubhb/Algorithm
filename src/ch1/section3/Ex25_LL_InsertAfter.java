// Write a method insertAfter() that takes two linked-list Node arguments and
// inserts the second after the first on its list (and does nothing if either argument is null).

package ch1.section3;

import java.util.List;

public class Ex25_LL_InsertAfter<T> {

  private Node head;
  private int size;

  public int size() {
    return size;
  }

  public void insertAfter(Node node, Node newNode) {
    if (node == null || newNode == null) {
      return;
    }
    ++size;
    newNode.next = node.next;
    node.next = newNode;
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

  public void pushFront(T item) {
    head = new Node(item, head);
    ++size;
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

  public static class Node<T> {

    T data;
    Node next;

    public Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}

class Ex25_Helper {

  public static <T> Ex25_LL_InsertAfter<T> buildLinkedList(List<T> list) {
    Ex25_LL_InsertAfter<T> ll = new Ex25_LL_InsertAfter<>();
    for (T obj : list) {
      ll.pushFront(obj);
    }
    return ll;
  }
}