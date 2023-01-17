package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex30LLTest {

  @Test
  void testReverse() {
    Ex30_LL_Reverse<String> ll = Ex30_Helper.buildLinkedList(
        Arrays.asList("a b c d e".split(" ")));
    ll.reverse();
    assertEquals("[a, b, c, d, e]", ll.toString());
  }

  @Test
  void testReverseRecursive() {
    Ex30_LL_Reverse<String> ll = Ex30_Helper.buildLinkedList(
        Arrays.asList("a b c d e".split(" ")));
    ll.recursiveReverse();
    assertEquals("[a, b, c, d, e]", ll.toString());
  }

  @Test
  public void testLinkedList() {
    Ex30_LL_Reverse<String> ll = Ex30_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("[times, of, best, the, was, It]", ll.toString());
  }
}