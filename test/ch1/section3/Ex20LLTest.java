package ch1.section3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex20LLTest {

  @Test
  void testRemoveKthNode() {
    Ex20_LL_RemoveKth<String> ll = Ex20_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("times", ll.removeKthNode(0));
    assertEquals("best", ll.removeKthNode(1));
    assertEquals(4, ll.size());
    assertEquals("It", ll.removeKthNode(3));
  }

  @Test
  public void testLinkedList() {
    Ex20_LL_RemoveKth<String> ll = Ex20_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("[times, of, best, the, was, It]", ll.toString());
  }
}