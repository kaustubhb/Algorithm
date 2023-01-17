package ch1.section3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class Ex47_CatenableStackTest {

  @Test
  public void testStack() {
    Ex47_CatenableStack<String> fs = new Ex47_CatenableStack<>();
    String str = "it was - the best - of times - - - it was - the - -";
    String[] strs = str.split(" ");
    List<String> popped = new ArrayList<>();
    for (String s : strs) {
      if (!s.equals("-")) {
        fs.push(s);
      } else {
        popped.add(fs.pop());
      }
    }
    assertEquals(String.join(" ", popped), "was best times of the was the it");
    assertEquals(fs.size(), 1);
    assertEquals(fs.pop(), "it");
  }

  @Test
  public void testEmpty() {
    Ex47_CatenableStack<String> fs = new Ex47_CatenableStack<>();

    assertTrue(fs.isEmpty());
    Exception ex = assertThrows(RuntimeException.class, fs::pop);
    assertEquals("Trying to pop from an empty stack", ex.getMessage());
  }

  @Test
  public void testIteration() {
    Ex47_CatenableStack<String> fs = new Ex47_CatenableStack<>();
    String[] input = "it was the best of times".split(" ");
    for (var s : input) {
      fs.push(s);
    }
    List<String> ls = new ArrayList<>();
    for (var s : fs) {
      ls.add(s);
    }
    Collections.reverse(ls);
    assertArrayEquals("it was the best of times".split(" "), ls.toArray());
  }

  @Test
  public void testCatenation() {
    Ex47_CatenableStack<String> stack1 = new Ex47_CatenableStack<>();
    Ex47_CatenableStack<String> stack2 = new Ex47_CatenableStack<>();
    for (String s : "a b c".split(" ")) {
      stack1.push(s);
    }
    for (String s : "d e f".split(" ")) {
      stack2.push(s);
    }
    Ex47_CatenableStack<String> q3 = Ex47_CatenableStack.catenateStacks(stack1, stack2);
    assertEquals(6, q3.size());
    List<String> elements = new ArrayList<>();
    for (String s : q3) {
      elements.add(s);
    }
    assertEquals("c b a f e d", String.join(" ", elements));
  }
}