// Give a code fragment that removes the last node in a linked list whose first node is given.

package ch1.section3;

import java.util.List;

public class Ex19_LL_RemoveLast<T> {

  private Node head;
  private int size;

  public int size() {
    return size;
  }

  public void pushFront(T item) {
    head = new Node(item, head);
    ++size;
  }

  public T removeLast() {
    if (head == null) {
      return null;
    }
    --size;
    if (head.next == null) {
      T temp = head.data;
      head = null;
      return temp;
    }
    Node current = head;
    while (current.next.next != null) {
      current = current.next;
    }
    T temp = current.next.data;
    current.next = null;
    return temp;
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

class Ex19_Helper {

  public static <T> Ex19_LL_RemoveLast<T> buildLinkedList(List<T> list) {
    Ex19_LL_RemoveLast<T> ll = new Ex19_LL_RemoveLast<>();
    for (T obj : list) {
      ll.pushFront(obj);
    }
    return ll;
  }
}
