package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Ex31DoublyLinkedListTest {

  @Test
  public void testRemoveFront() {
    Ex31_DoublyLinkedList<String> dll = new Ex31_DoublyLinkedList<>();
    for (String t : "random text".split(" ")) {
      dll.insertEnd(t);
    }
    assertTrue(dll.isValid());
    assertEquals(dll.removeFront(), "random");
    assertEquals(dll.toString(), "[[text]]");
    dll.removeFront();
    assertEquals(dll.toString(), "[[]]");
    assertTrue(dll.isValid());

    Exception ex = assertThrows(RuntimeException.class, dll::removeFront);
    assertEquals("Attempt to remove from empty list", ex.getMessage());
  }

  @Test
  public void testInsertEnd() {
    Ex31_DoublyLinkedList<String> dll = new Ex31_DoublyLinkedList<>();
    String s = "Just some random text";
    String[] tokens = s.split(" ");
    for (String t : tokens) {
      dll.insertEnd(t);
    }
    assertEquals(dll.toString(), String.format("[[%s]]",
        String.join("-", s.split(" "))));
  }

  @Test
  public void testInsertFront() {
    Ex31_DoublyLinkedList<String> dll = new Ex31_DoublyLinkedList<>();
    String s = "Just some random text";
    String[] tokens = s.split(" ");
    for (String t : tokens) {
      dll.insertFront(t);
    }
    assertEquals(dll.toString(), "[[text-random-some-Just]]");
  }

  @Test
  public void testRemoveNode() {
    Ex31_DoublyLinkedList<String> dll = new Ex31_DoublyLinkedList<>();
    String s = "Just some random text";
    String[] tokens = s.split(" ");
    for (String t : tokens) {
      dll.insertEnd(t);
    }
    dll.removeNode(dll.getNodeAt(1));
    dll.removeNode(dll.getNodeAt(0));
    dll.removeNode(dll.getNodeAt(1));
    assertEquals(dll.size(), 1);
    assertEquals(dll.getNodeAt(0).item, "random");
  }

  @Test
  public void testRemoveEnd() {
    Ex31_DoublyLinkedList<String> dll = new Ex31_DoublyLinkedList<>();
    String s = "Just some random text";
    String[] tokens = s.split(" ");
    for (String t : tokens) {
      dll.insertEnd(t);
    }
    assertEquals(dll.removeEnd(), "text");
    assertEquals(dll.size(), 3);
    assertEquals(dll.toString(), "[[Just-some-random]]");

    while (!dll.isEmpty()) {
      dll.removeEnd();
    }
    assertEquals(dll.size(), 0);
    assertEquals(dll.toString(), "[[]]");
  }

  @Test
  public void testInsertBefore() {
    Ex31_DoublyLinkedList<String> dll = new Ex31_DoublyLinkedList<>();
    String s = "a b c";
    String[] tokens = s.split(" ");
    for (String t : tokens) {
      dll.insertEnd(t);
    }
    dll.insertBefore(null, "z");
    dll.insertBefore(dll.getNodeAt(2), "y");
    dll.insertBefore(dll.getNodeAt(1), "x");
    dll.insertBefore(dll.getNodeAt(0), "w");

    assertEquals("[[w-a-x-b-y-c-z]]", dll.toString());
  }

  @Test
  public void testInsertAfter() {
    Ex31_DoublyLinkedList<String> dll = new Ex31_DoublyLinkedList<>();
    String s = "a b c";
    String[] tokens = s.split(" ");
    for (String t : tokens) {
      dll.insertEnd(t);
    }
    dll.insertAfter(null, "w");
    dll.insertAfter(dll.getNodeAt(1), "x");
    dll.insertAfter(dll.getNodeAt(3), "y");
    dll.insertAfter(dll.getNodeAt(5), "z");

    assertEquals("[[w-a-x-b-y-c-z]]", dll.toString());
  }
}
