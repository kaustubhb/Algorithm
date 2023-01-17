// Faster 2-sum.Implement a linear algorithm for TwoSum problem.

package ch1.section4;

import java.util.Arrays;

public class Ex15_FasterTwoSum {

  public static int countPairs(int[] values) {
    Arrays.sort(values);
    int count = 0;
    int i = 0, j = values.length - 1;
    while (i < j) {
      while (j > i && values[i] + values[j] > 0) {
        --j;
      }
      if (values[i] + values[j] == 0) {
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
}
