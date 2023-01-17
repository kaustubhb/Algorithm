package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FixedCapacityStackOfStringsTest {

  @Test
  void testStack() {
    String[] input = "to be or not to - be - - that - - - is".split(" ");
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
    for (var s : input) {
      if (s.equals("-")) {
        stack.pop();
      } else {
        stack.push(s);
      }
    }
    assertEquals(2, stack.size());
    assertEquals("is", stack.pop());
    assertEquals("to", stack.pop());
    assertThrows(RuntimeException.class, () -> {
      stack.pop();
    });
  }
}