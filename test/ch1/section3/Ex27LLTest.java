package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex27LLTest {

  @Test
  void testMax() {
    Ex27_LL_Max<String> ll = Ex27_Helper.buildLinkedList(
        Arrays.asList("d a c r f s a v p x".split(" ")));
    assertEquals("x", ll.max(ll.getNodeAt(0)));
    assertEquals("v", ll.max(ll.getNodeAt(1)));
    assertEquals("d", ll.max(ll.getNodeAt(9)));
  }

  @Test
  public void testLinkedList() {
    Ex27_LL_Max<String> ll = Ex27_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("[times, of, best, the, was, It]", ll.toString());
  }
}