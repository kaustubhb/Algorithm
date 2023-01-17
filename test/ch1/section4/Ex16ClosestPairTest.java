package ch1.section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Ex16ClosestPairTest {

  @Test
  void testClosestPair() {
    Assertions.assertEquals(new Ex16_ClosestPair.Pair(1, 2),
        Ex16_ClosestPair.closestPair(new int[]{2, 1, 3}));
    Assertions.assertEquals(new Ex16_ClosestPair.Pair(13, 20),
        Ex16_ClosestPair.closestPair(new int[]{20, 13, 29}));
  }
}