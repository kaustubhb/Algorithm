package ch1.section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Ex144SumTest {

  @Test
  void testCountQuadruples() {
    Assertions.assertEquals(1, Ex14_4Sum.countQuadruples(new int[]{2, 4, -1, -5}));
  }
}