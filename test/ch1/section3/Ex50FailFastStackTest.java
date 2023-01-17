package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.junit.jupiter.api.Test;

class Ex50FailFastStackTest {

  @Test
  public void testStack() {
    Ex50_FailFastStack<String> fs = new Ex50_FailFastStack<>();
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
    Ex50_FailFastStack<String> fs = new Ex50_FailFastStack<>();

    assertTrue(fs.isEmpty());
    Exception ex = assertThrows(RuntimeException.class, fs::pop);
    assertEquals("Trying to pop from an empty stack", ex.getMessage());
  }

  @Test
  public void testIteration() {
    Ex50_FailFastStack<String> fs = new Ex50_FailFastStack<>();
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
  public void testConcurrentModification() {
    Ex50_FailFastStack<String> fs = new Ex50_FailFastStack<>();
    String[] input = "it was the best of times".split(" ");
    for (var s : input) {
      fs.push(s);
    }
    Exception ex = assertThrows(ConcurrentModificationException.class, () -> {
      List<String> ls = new ArrayList<>();
      int i = 0;
      for (var s : fs) {
        if (++i % 5 == 0) {
          fs.push("check");
        }
        ls.add(s);
      }
    });
    assertEquals("Stack was modified during iteration", ex.getMessage());

  }

}