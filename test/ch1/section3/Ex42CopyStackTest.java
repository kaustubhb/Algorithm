package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex42CopyStackTest {

  @Test
  void copyStack() {
    Stack<String> stack = new Stack<>();
    for (String s : "Whatever you are be a good one".split(" ")) {
      stack.push(s);
    }
    assertEquals("[one, good, a, be, are, you, Whatever]", stack.toString());
    assertEquals(stack.toString(), Ex42_CopyStack.copyStack(stack).toString());
  }
}