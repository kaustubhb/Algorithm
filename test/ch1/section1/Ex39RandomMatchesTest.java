package ch1.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex39RandomMatchesTest {

  @Test
  void testCountDuplicates() {
    assertEquals(2,
        Ex39_RandomMatches.countDuplicates(new int[]{1, 2, 3, 4}, new int[]{1, 2, 2, 5}));
    assertEquals(3,
        Ex39_RandomMatches.countDuplicates(new int[]{1, 2, 2, 2, 3, 4}, new int[]{1, 2, 2, 5}));
    assertEquals(1,
        Ex39_RandomMatches.countDuplicates(new int[]{1, 2, 3}, new int[]{1, 1, 1}));

  }
}