// 4-sum. Develop an algorithm for the 4-sum problem.

package ch1.section4;

public class Ex14_4Sum {

  public static int countQuadruples(int[] values) {
    int count = 0;
    for (int i = 0; i < values.length; ++i) {
      for (int j = i + 1; j < values.length; ++j) {
        for (int k = j + 1; k < values.length; ++k) {
          for (int u = k + 1; u < values.length; ++u) {
            if (values[i] + values[j] + values[k] + values[u] == 0) {
              ++count;
            }
          }
        }
      }
    }
    return count;
  }
}
