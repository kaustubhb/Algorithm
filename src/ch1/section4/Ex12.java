// Write a program that, given two sorted arrays of N int values, prints all elements
// that appear in both arrays, in sorted order. The running time of your program
// should be proportional to n in the worst case.

package ch1.section4;

import java.util.ArrayList;
import java.util.List;

public class Ex12 {

  public static int[] findCommonElements(int[] a1, int[] a2) {
    List<Integer> result = new ArrayList<>();
    int i = 0, j = 0;
    while (i < a1.length) {
      int val = a1[i], a1Count = 1, a2Count = 0;
      while (++i < a1.length && a1[i] == val) {
        ++a1Count;
      }
      while (j < a2.length && a2[j] < val) {
        ++j;
      }
      while (j < a2.length && a2[j] == val) {
        ++j;
        ++a2Count;
      }
      for (int k = 0; k < Math.min(a1Count, a2Count); ++k) {
        result.add(val);
      }
    }
    return result.stream().mapToInt(x -> x).toArray();
  }

}
