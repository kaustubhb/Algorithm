package ch1.section3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FixedCapacityStackTest {

  @Test
  void testStack() {
    String[] input = "to be or not to - be - - that - - - is".split(" ");
    FixedCapacityStack<String> stack = new FixedCapacityStack<>(10);
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
    assertThrows(RuntimeException.class, stack::pop);
  }
}