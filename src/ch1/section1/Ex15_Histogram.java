// 1.1.15 Write a static method histogram() that takes an array a[] of int values and
//	an integer M as arguments and returns an array of length M whose ith entry is the
//	number of times the integer i appeared in the argument array. If the values
//	in a[] are all between 0 and M–1, the sum of the values in the returned array
//	should be equal to a.length.

package ch1.section1;

public class Ex15_Histogram {

  public static int[] histogram(int[] a, int m) {
    int[] result = new int[m];

    for (int j : a) {
      assert (j >= 0 && j < m);
      ++result[j];
    }
    return result;
  }
}
