package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex24LLTest {

  @Test
  void removeAfter() {
    Ex24_LL_RemoveAfter<String> ll = Ex24_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("the", ll.removeAfter(ll.getNodeAt(2)));
    assertEquals("of", ll.removeAfter(ll.getNodeAt(0)));
    assertEquals("It", ll.removeAfter(ll.getNodeAt(2)));
    assertNull(ll.removeAfter(ll.getNodeAt(2)));
    assertEquals(3, ll.size());
  }

  @Test
  public void testLinkedList() {
    Ex24_LL_RemoveAfter<String> ll = Ex24_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("[times, of, best, the, was, It]", ll.toString());
  }
}