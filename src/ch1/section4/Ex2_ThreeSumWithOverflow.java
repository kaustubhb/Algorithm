// Modify ThreeSum to work properly even when the int values are so large that
// adding two of them might cause overflow.

package ch1.section4;

import ch1.section1.BinarySearch;
import java.util.Arrays;

public class Ex2_ThreeSumWithOverflow {

  public static int countTriples(int[] arr) {
    Arrays.sort(arr);
    int count = 0;
    for (int i = 0; i < arr.length; ++i) {
      for (int j = i + 1; j < arr.length; ++j) {
        if (!overflowOnAdd(arr[i], arr[j])) {
          int rank = BinarySearch.rank(-arr[i] - arr[j], arr);
          if (rank > j) {
            ++count;
          } else if (rank > 0) {
            break;
          }
        }
      }
    }
    return count;
  }

  private static boolean overflowOnAdd(int a, int b) {
    int sum = a + b;
    return a < 0 && b < 0 && sum >= 0 || a > 0 && b > 0 && sum <= 0;
  }

  public static void main(String[] args) {
    System.out.println(countTriples(new int[]{Integer.MAX_VALUE - 1, 3, Integer.MAX_VALUE}) == 0);
  }
}
