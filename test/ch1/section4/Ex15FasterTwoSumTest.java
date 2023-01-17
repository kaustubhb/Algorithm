package ch1.section4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex15FasterTwoSumTest {

  @Test
  void testCountPairs() {
    assertEquals(0, Ex15_FasterTwoSum.countPairs(new int[]{1, 2, 1, 1, 2}));
    assertEquals(3, Ex15_FasterTwoSum.countPairs(new int[]{-5, -4, 1, 2, 4, 4, 5}));
    assertEquals(2, Ex15_FasterTwoSum.countPairs(new int[]{-4, 4, 4}));
    assertEquals(2, Ex15_FasterTwoSum.countPairs(new int[]{-4, -4, 4}));
    assertEquals(0, Ex15_FasterTwoSum.countPairs(new int[]{-1, -2}));
    assertEquals(1, Ex15_FasterTwoSum.countPairs(new int[]{0, 0}));
    assertEquals(6, Ex15_FasterTwoSum.countPairs(new int[]{0, 0, 0, 0}));
  }
}