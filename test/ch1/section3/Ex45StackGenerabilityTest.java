package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static  ch1.section3.Ex45_StackGenerability.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex45StackGenerabilityTest {

  @Test
  void testWillUnderflow() {
    assertFalse(willUnderflow("012---"));
    assertTrue(willUnderflow("01-2---"));
  }

  @Test
  void testIsValidSequence() {
    assertTrue(isValidSequence(generateIntArray("4 3 2 1 0 9 8 7 6 5")));
    assertFalse(isValidSequence(generateIntArray("4 6 8 7 5 3 2 9 0 1")));
    assertTrue(isValidSequence(generateIntArray("2 5 6 7 4 8 9 3 1 0")));
    assertTrue(isValidSequence(generateIntArray("4 3 2 1 0 5 6 7 8 ")));
    assertFalse(isValidSequence(generateIntArray("0 4 6 5 3 8 1 7 2 9")));
  }

  private int[] generateIntArray(String seq) {
    return Arrays.stream(seq.split(" ")).mapToInt(Integer::parseInt)
        .toArray();
  }
}