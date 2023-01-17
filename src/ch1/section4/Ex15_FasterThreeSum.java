// Faster 3-sum.Implement a linear algorithm for ThreeSum problem.

package ch1.section4;

import java.util.Arrays;

public class Ex15_FasterThreeSum {

  private static int countPairs(int[] values, int target, int beg) {
    int count = 0;
    int i = beg, j = values.length - 1;
    while (i < j) {
      while (j > i && values[i] + values[j] > target) {
        --j;
      }
      if (values[i] + values[j] == target) {
        int x = values[i], y = values[j];
        int countX = 1, countY = 1;
        while (i < j && values[++i] == x) {
          ++countX;
        }
        while (i < j && values[--j] == y) {
          ++countX;
        }
        if (x != y) {
          count += countX * countY;
        } else {
          count += countX * (countX - 1) / 2;
        }
      } else {
        ++i;
      }
    }
    return count;
  }

  public static int countTriplets(int[] values) {
    Arrays.sort(values);
    int count = 0;
    for (int i = 1; i < values.length; ++i) {
      count += countPairs(values, -values[i - 1], i);
    }
    return count;
  }
}
