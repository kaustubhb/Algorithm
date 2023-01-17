package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex19LLTest {

  @Test
  public void testLinkedList() {
    Ex19_LL_RemoveLast<String> ll = Ex19_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("[times, of, best, the, was, It]", ll.toString());
  }

  @Test
  void removeLast() {
    Ex19_LL_RemoveLast<String> ll = Ex19_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("It", ll.removeLast());
    assertEquals("was", ll.removeLast());
    assertEquals(4, ll.size());
  }
}