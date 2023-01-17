package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch1.section3.Ex25_LL_InsertAfter.Node;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex25LLTest {

  @Test
  void insertAfter() {
    Ex25_LL_InsertAfter<String> ll = Ex25_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    ll.insertAfter(ll.getNodeAt(0), new Node<>("aa", null));
    ll.insertAfter(ll.getNodeAt(6), new Node<>("bb", null));
    assertEquals("[times, aa, of, best, the, was, It, bb]", ll.toString());
    assertEquals(8, ll.size());
  }

  @Test
  public void testLinkedList() {
    Ex25_LL_InsertAfter<String> ll = Ex25_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("[times, of, best, the, was, It]", ll.toString());
  }
}