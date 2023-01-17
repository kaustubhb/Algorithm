package ch1.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagTest {

  @Test
  public void testBag() {
    Bag<Integer> bag = new Bag<>();
    for (int i = 0; i < 10; ++i) {
      bag.add(i * i);
    }
    Assertions.assertEquals(bag.size(), 10);

    int sum = 0;
    for (int x : bag) {
      sum += x;
    }
    Assertions.assertEquals(sum, 285);
  }
}