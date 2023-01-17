/* 1.3.38 Delete kth element. Implement a class that supports the given API.
 * First, develop an implementation that uses an array implementation,
 * and then develop one that uses a linked-list implementation.
 */

package ch1.section3;

public class Ex38_GeneralizedQueue_LL<Item> {

  private Node head, last;
  private int count = 0;

  public boolean isEmpty() {
    return count == 0;
  }

  public int size() {
    return count;
  }

  public void insert(Item it) {
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

  public Item delete(int k) {
    if (k >= size()) {
      throw new RuntimeException("Invalid index for deletion.");
    }
    if (k == 0) {
      Item temp = head.item;
      head = head.next;
      if (size() == 1) {
        last = null;
      }
      --count;
      return temp;
    }
    int i = 1;
    Node current = head;
    while (i++ < k) {
      current = current.next;
    }
    Item temp = current.next.item;
    current.next = current.next.next;
    if (current.next == null) {
      last = current;
    }
    --count;
    return temp;
  }

  private class Node {

    Item item;
    Node next;
  }
}
