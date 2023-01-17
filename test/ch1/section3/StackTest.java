package ch1.section3;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StackTest {

  @Test
  public void testStack() {
    Stack<String> fs = new Stack<>();
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
    assertEquals(fs.peek(), "it");
    assertEquals(fs.pop(), "it");
  }

  @Test
  public void testEmpty() {
    Stack<String> fs = new Stack<>();

    assertTrue(fs.isEmpty());
    Exception ex = assertThrows(RuntimeException.class, fs::pop);
    assertEquals("Trying to pop from an empty stack", ex.getMessage());
  }

  @Test
  public void testIteration() {
    Stack<String> fs = new Stack<>();
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

}