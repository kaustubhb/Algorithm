package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex40MoveToFrontTest {

  @Test
  public void testMoveToFront() {
    Ex40_MoveToFront ll = new Ex40_MoveToFront();
    for (int x : "abacdaa".chars().toArray()) {
      ll.add((char) x);
    }
    assertEquals("[a, d, c, b]", ll.toString());
    assertEquals(4, ll.size());
  }
}