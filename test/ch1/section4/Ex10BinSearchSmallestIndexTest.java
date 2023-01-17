package ch1.section4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex10BinSearchSmallestIndexTest {

  @Test
  void testRankFirst() {
    int[] arr1 = {10, 20, 20, 20, 30, 40, 50, 60, 60};
    assertEquals(0, Ex10_BinSearchSmallestIndex.rankFirst(arr1, 10), 0);
    assertEquals(5, Ex10_BinSearchSmallestIndex.rankFirst(arr1, 40));
    assertEquals(1, Ex10_BinSearchSmallestIndex.rankFirst(arr1, 20));
    assertEquals(-1, Ex10_BinSearchSmallestIndex.rankFirst(arr1, 35));
  }
}