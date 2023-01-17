package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Ex34RandomBagTest {

  @Test
  public void testBag() {
    Ex34_RandomBag<Integer> bag = new Ex34_RandomBag<>();
    assertTrue(bag.isEmpty());
    for (int i = 0; i < 10; ++i) {
      bag.add(i * i);
    }
    assertEquals(bag.size(), 10);

    int sum = 0;
    for (int x : bag) {
      sum += x;
    }
    assertEquals(sum, 285);
  }
}