package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex26LLTest {

  @Test
  void testRemove() {
    Ex26_LL_Remove<String> ll = Ex26_Helper.buildLinkedList(
        Arrays.asList("a b c d a d b a d f c a a".split(" ")));
    ll.remove("a");
    assertEquals("[c, f, d, b, d, d, c, b]", ll.toString());
    ll.remove("d");
    assertEquals("[c, f, b, c, b]", ll.toString());
  }

  @Test
  public void testLinkedList() {
    Ex26_LL_Remove<String> ll = Ex26_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("[times, of, best, the, was, It]", ll.toString());
  }
}