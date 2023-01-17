package ch1.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex29BinarySearchWithCountTest {

  @Test
  public void testRankFirst() {
    int[] arr1 = {10, 20, 20, 20, 30, 40, 50, 60, 60};
    assertEquals(Ex29_BinarySearchWithCount.rankFirst(arr1, 10), 0);
    assertEquals(Ex29_BinarySearchWithCount.rankFirst(arr1, 40), 5);
    assertEquals(Ex29_BinarySearchWithCount.rankFirst(arr1, 20), 1);
    assertEquals(Ex29_BinarySearchWithCount.rankFirst(arr1, 35), -5);
  }

  @Test
  public void testRankLast() {
    int[] arr1 = {10, 20, 20, 20, 30, 40, 50, 60, 60};
    assertEquals(Ex29_BinarySearchWithCount.rankLast(arr1, 10), 0);
    assertEquals(Ex29_BinarySearchWithCount.rankLast(arr1, 40), 5);
    assertEquals(Ex29_BinarySearchWithCount.rankLast(arr1, 20), 3);
    assertEquals(Ex29_BinarySearchWithCount.rankLast(arr1, 15), -1);
  }

  @Test
  public void testRank() {
    int[] arr1 = {10, 20, 20, 20, 30, 40, 50, 60, 60};
    assertEquals(Ex29_BinarySearchWithCount.rank(arr1, 10), 0);
    assertEquals(Ex29_BinarySearchWithCount.rank(arr1, 40), 5);
    assertEquals(Ex29_BinarySearchWithCount.rank(arr1, 20), 1);
    assertEquals(Ex29_BinarySearchWithCount.rank(arr1, 35), -1);
  }

  @Test
  public void count() {
    int[] arr1 = {10, 20, 20, 20, 30, 40, 50, 60, 60};
    assertEquals(Ex29_BinarySearchWithCount.count(arr1, 10), 1);
    assertEquals(Ex29_BinarySearchWithCount.count(arr1, 40), 1);
    assertEquals(Ex29_BinarySearchWithCount.count(arr1, 20), 3);
    assertEquals(Ex29_BinarySearchWithCount.count(arr1, 15), 0);
  }
}