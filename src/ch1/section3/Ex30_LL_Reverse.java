// Write a function that takes the first Node in a linked list as argument and (destructively)
// reverses the list, returning the first Node in the result.

package ch1.section3;

import java.util.List;

public class Ex30_LL_Reverse<T> {

  private Node head;
  private int size;

  public int size() {
    return size;
  }

  public void pushFront(T item) {
    head = new Node(item, head);
    ++size;
  }

  public void reverse() {
    if (head == null || head.next == null) {
      return;
    }
    Node f = head;
    Node s = f.next;
    Node t = s.next;
    head.next = null;
    while (true) {
      s.next = f;
      if (t == null) {
        head = s;
        return;
      }
      f = s;
      s = t;
      t = t.next;
    }
  }

  public void recursiveReverse() {
    head = recursiveReverse(head);
  }

  private Node recursiveReverse(Node f) {
    if (f == null || f.next == null) {
      return f;
    }
    Node s = f.next;
    Node newHead = recursiveReverse(s);
    s.next = f;
    f.next = null;
    return newHead;
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

class Ex30_Helper {

  public static <T extends Comparable<T>> Ex30_LL_Reverse<T> buildLinkedList(List<T> list) {
    Ex30_LL_Reverse<T> ll = new Ex30_LL_Reverse<>();
    for (T obj : list) {
      ll.pushFront(obj);
    }
    return ll;
  }
}
