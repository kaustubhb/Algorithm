package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Ex32StequeTest {

  private Ex32_Steque<String> createSteque() {
    Ex32_Steque<String> stq = new Ex32_Steque<String>();
    String s = "Just some random text";
    String[] tokens = s.split(" ");
    for (String t : tokens) {
      stq.enqueue(t);
    }
    return stq;
  }

  @Test
  public void testIsEmpty() {
    Ex32_Steque<String> stq = createSteque();
    assertFalse(stq.isEmpty());
    int sz = stq.size();
    for (int i = 0; i < sz; ++i) {
      stq.pop();
    }
    assertTrue(stq.isEmpty());
  }

  @Test
  public void testSize() {
    Ex32_Steque<String> stq = createSteque();
    int sz = 4;
    for (int i = sz; i > 0; --i) {
      assertEquals(stq.size(), i);
      stq.pop();
    }
    assertEquals(stq.size(), 0);
  }

  /**
   * Test method for {@link Ex32_Steque#enqueue(Object)}.
   */
  @Test
  public void testEnqueue() {
    String s = "Just some random text";
    String[] tokens = s.split(" ");
    Ex32_Steque<String> stq = new Ex32_Steque<String>();
    for (String t : tokens) {
      stq.enqueue(t);
    }
    int i = 0;
    for (String t : stq) {
      assertEquals(t, tokens[i++]);
    }
  }

  @Test
  public void testPush() {
    String s = "Just some random text";
    String[] tokens = s.split(" ");
    Ex32_Steque<String> stq = new Ex32_Steque<String>();
    for (String t : tokens) {
      stq.push(t);
    }
    int i = 3;
    for (String t : stq) {
      assertEquals(t, tokens[i--]);
    }
  }

  @Test
  public void testPop() {
    String s = "Just some random text";
    String[] tokens = s.split(" ");
    Ex32_Steque<String> stq = new Ex32_Steque<String>();
    for (String t : tokens) {
      stq.push(t);
    }
    int i = 3;
    while (!stq.isEmpty()) {
      assertEquals(stq.pop(), tokens[i--]);
    }
  }
}
