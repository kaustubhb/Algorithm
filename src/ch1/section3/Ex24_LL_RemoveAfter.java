// Write a method removeAfter() that takes a linked-list Node as argument and
// removes the node following the given one (and does nothing if the argument or the next
// field in the argument node is null).

package ch1.section3;

import java.util.List;

public class Ex24_LL_RemoveAfter<T> {

  private Node head;
  private int size;

  public int size() {
    return size;
  }

  public T removeAfter(Node node) {
    if (node == null || node.next == null) {
      return null;
    }
    --size;
    T temp = node.next.data;
    node.next = node.next.next;
    return temp;
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

  public class Node {

    T data;
    Node next;

    public Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}

class Ex24_Helper {

  public static <T> Ex24_LL_RemoveAfter<T> buildLinkedList(List<T> list) {
    Ex24_LL_RemoveAfter<T> ll = new Ex24_LL_RemoveAfter<>();
    for (T obj : list) {
      ll.pushFront(obj);
    }
    return ll;
  }
}