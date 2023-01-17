package ch1.section4;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class Ex12Test {

  @Test
  void testFindCommonElements() {
    assertArrayEquals(new int[]{1, 5, 7},
        Ex12.findCommonElements(new int[]{1, 5, 7, 8}, new int[]{1, 3, 4, 5, 6, 7}));
    assertArrayEquals(new int[]{1, 1, 5, 7, 7},
        Ex12.findCommonElements(new int[]{1, 1, 1, 5, 7, 7, 8}, new int[]{1, 1, 3, 4, 5, 6, 7, 7}));
  }
}