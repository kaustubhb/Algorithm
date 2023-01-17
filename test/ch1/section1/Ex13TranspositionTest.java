package ch1.section1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class Ex13TranspositionTest {

  @Test
  void testTranspose() {
    assertArrayEquals(new int[][]{{1, 3}, {2, 4}},
        Ex13_Transposition.transpose(new int[][]{{1, 2}, {3, 4}}));
    assertArrayEquals(new int[][]{{1}, {2}},
        Ex13_Transposition.transpose(new int[][]{{1, 2}}));
  }
}