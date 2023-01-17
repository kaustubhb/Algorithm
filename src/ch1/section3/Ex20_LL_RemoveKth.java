// Write a method delete() that takes an int argument k and deletes the kth element
// in a linked list, if it exists.

package ch1.section3;

import java.util.List;

public class Ex20_LL_RemoveKth<T> {

  private Node head;
  private int size;

  public int size() {
    return size;
  }

  public void pushFront(T item) {
    head = new Node(item, head);
    ++size;
  }

  // k -> [0, size)
  public T removeKthNode(int k) {
    if (k >= size()) {
      throw new RuntimeException("k should be less than list size");
    }
    --size;
    if (k == 0) {
      T temp = head.data;
      head = head.next;
      return temp;
    }
    Node current = head;
    int i = 0;
    while (i++ < k - 1) {
      current = current.next;
    }
    T temp = current.next.data;
    current.next = current.next.next;
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

class Ex20_Helper {

  public static <T> Ex20_LL_RemoveKth<T> buildLinkedList(List<T> list) {
    Ex20_LL_RemoveKth<T> ll = new Ex20_LL_RemoveKth<>();
    for (T obj : list) {
      ll.pushFront(obj);
    }
    return ll;
  }
}
