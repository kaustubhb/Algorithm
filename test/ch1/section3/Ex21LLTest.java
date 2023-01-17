package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex21LLTest {

  @Test
  void testFind() {
    Ex21_LL_Find<String> ll = Ex21_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertTrue(ll.find("times"));
    assertTrue(ll.find("best"));
    assertTrue(ll.find("It"));
    assertFalse(ll.find("aa"));
  }

  @Test
  public void testLinkedList() {
    Ex21_LL_Find<String> ll = Ex21_Helper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("[times, of, best, the, was, It]", ll.toString());
  }
}