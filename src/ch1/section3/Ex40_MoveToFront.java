//  Move-to-front. Read in a sequence of characters from standard input and
//	maintain the characters in a linked list with no duplicates. When you read in a previously
//	unseen character, insert it at the front of the list. When you read in a duplicate
//	character, delete it from the list and reinsert it at the beginning. Name your program
//	Ex40_MoveToFront: it implements the well-known move-to-front strategy, which is useful for
//	caching, data compression, and many other applications where items that have been
//	recently accessed are more likely to be reaccessed.
package ch1.section3;

public class Ex40_MoveToFront {

  private Node head;
  private int size;

  public void add(char c) {
    if (head == null) {
      head = new Node(c, null);
      ++size;
      return;
    }
    if (head.data == c) {
      return;
    }
    Node current = head;
    while (current.next != null && current.next.data != c) {
      current = current.next;
    }
    if (current.next != null) {
      current.next = current.next.next;
      --size;
    }
    head = new Node(c, head);
    ++size;
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

  public class Node {

    char data;
    Node next;

    public Node(char data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
