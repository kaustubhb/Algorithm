package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResizingArrayStackTest {

  @Test
  public void testStack() {
    ResizingArrayStack<String> fs = new ResizingArrayStack<>();
    String str = "to be or not to - be - - that - - - is";
    String[] strs = str.split(" ");
    List<String> popped = new ArrayList<>();
    for (String s : strs) {
      if (!s.equals("-")) {
        fs.push(s);
      } else {
        popped.add(fs.pop());
      }
    }
    assertEquals(String.join(" ", popped), "to be not that or be");
    assertEquals(fs.size(), 2);
    assertEquals(fs.pop(), "is");
    assertEquals(fs.pop(), "to");
  }

  @Test
  public void testEmpty() {
    ResizingArrayStack<String> fs = new ResizingArrayStack<>();

    assertTrue(fs.isEmpty());
    Exception ex = assertThrows(RuntimeException.class, fs::pop);
    assertEquals("Trying to pop from an empty stack", ex.getMessage());
  }

  @Test
  public void testStack2() {
    ResizingArrayStack<String> fs = new ResizingArrayStack<>();
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
    assertEquals(fs.size(), 1);
  }
}