package ch1.section4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex15_FasterThreeSumTest {

  @Test
  void testCountTriplets() {
    assertEquals(0, Ex15_FasterThreeSum.countTriplets(new int[]{1, 2, 1, 1, 2}));
    assertEquals(6, Ex15_FasterThreeSum.countTriplets(new int[]{-5, -4, -3, -2, 1, 1, 2, 3}));
  }
}