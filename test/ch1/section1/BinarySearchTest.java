package ch1.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

  @Test
  void rank() {
    assertEquals(4, BinarySearch.rank(10, new int[]{1, 2, 3, 5, 10, 14}));
    assertEquals(0, BinarySearch.rank(1, new int[]{1, 2, 3, 5, 10, 14}));
    assertEquals(-1, BinarySearch.rank(4, new int[]{1, 2, 3, 5, 10, 14}));
    assertEquals(0, BinarySearch.rank(1, new int[]{1}));
    assertEquals(-1, BinarySearch.rank(1, new int[]{}));
  }
}