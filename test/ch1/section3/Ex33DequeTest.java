package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Ex33DequeTest {

  private Ex33_Deque<String> createDeque() {
    Ex33_Deque<String> dq = new Ex33_Deque<>();
    String s = "just some random text";
    String[] tokens = s.split(" ");
    for (String t : tokens) {
      dq.pushRight(t);
    }
    return dq;
  }

  @Test
  public void testIsEmpty() {
    Ex33_Deque<String> dq = createDeque();
    assertFalse(dq.isEmpty());
    int sz = dq.size();
    for (int i = 0; i < sz; ++i) {
      dq.popLeft();
    }
    assertTrue(dq.isEmpty());
  }

  @Test
  public void testSize() {
    Ex33_Deque<String> dq = createDeque();
    int sz = 4;
    for (int i = sz; i > 0; --i) {
      assertEquals(dq.size(), i);
      dq.popLeft();
    }
    assertEquals(dq.size(), 0);
  }

  @Test
  public void testPushLeft() {
    Ex33_Deque<String> dq = new Ex33_Deque<>();
    String text = "just some random text";
    for (String t : text.split(" ")) {
      dq.pushLeft(t);
    }
    String expected = "Ex33_Deque:[[text-random-some-just]]";
    assertEquals(dq.toString(), expected);
    assertTrue(dq.isValid());
  }

  @Test
  public void testPushRight() {
    Ex33_Deque<String> dq = new Ex33_Deque<>();
    String text = "just some random text";
    for (String t : text.split(" ")) {
      dq.pushRight(t);
    }
    String expected = "Ex33_Deque:[[just-some-random-text]]";
    assertEquals(dq.toString(), expected);
    assertTrue(dq.isValid());
  }

  @Test
  public void testPopLeft() {
    Ex33_Deque<String> dq = new Ex33_Deque<>();
    String text = "just random text";
    for (String t : text.split(" ")) {
      dq.pushRight(t);
    }
    String expected = "Ex33_Deque:[[just-random-text]]";
    assertEquals(dq.toString(), expected);
    assertTrue(dq.isValid());
    dq.popLeft();
    expected = "Ex33_Deque:[[random-text]]";
    assertEquals(dq.toString(), expected);
    assertTrue(dq.isValid());
    dq.popLeft();
    expected = "Ex33_Deque:[[text]]";
    assertEquals(dq.toString(), expected);
    assertTrue(dq.isValid());
    dq.popLeft();
    expected = "Ex33_Deque:[[]]";
    assertEquals(dq.toString(), expected);
    assertTrue(dq.isValid());

  }

  @Test
  public void testPopRight() {
    Ex33_Deque<String> dq = new Ex33_Deque<>();
    for (String t : "random text".split(" ")) {
      dq.pushRight(t);
    }
    assertEquals(dq.popRight(), "text");
    assertTrue(dq.isValid());
    assertEquals(dq.popRight(), "random");
    assertTrue(dq.isValid());
  }

  @Test
  public void testIteration() {
    Ex33_Deque<String> dq = new Ex33_Deque<>();
    String text = "some random text";
    for (String t : text.split(" ")) {
      dq.pushRight(t);
    }
    List<String> elements = new ArrayList<>();
    for (String s : dq) {
      elements.add(s);
    }
    assertArrayEquals(elements.toArray(), text.split(" "));
    elements.clear();
    for (String s : dq.forEachReverse()) {
      elements.add(s);
    }
    Collections.reverse(elements);
    assertArrayEquals(elements.toArray(), text.split(" "));
  }
}
