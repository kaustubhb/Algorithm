// Farthest pair (in one dimension). Write a program that, given an array a[] of N
// double values, finds a farthest pair : two values whose difference is no smaller than the
// the difference of any other pair (in absolute value). The running time of your program
// should be linear in the worst case.

package ch1.section4;

import ch1.section4.Ex16_ClosestPair.Pair;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ex17_FarthestPair {

  public static Pair farthestPair(int[] arr) {
    if (arr.length < 2) {
      throw new IllegalArgumentException("Array should have at least 2 elements");
    }
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();
    return new Pair(min, max);
  }

  @Test
  public void testFarthestPair() {
    Assertions.assertEquals(new Pair(1, 3),
       farthestPair(new int[]{2, 1, 3}));
    Assertions.assertEquals(new Pair(13, 29),
        farthestPair(new int[]{20, 13, 29}));
  }

}


