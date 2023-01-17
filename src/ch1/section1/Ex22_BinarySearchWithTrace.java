// Write a version of BinarySearch that uses the recursive rank() given on page
// 25 and traces the method calls. Each time the recursive method is called, print the
// argument values lo and hi, indented by the depth of the recursion. Hint: Add an argument
// to the recursive method that keeps track of the depth.

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import java.util.Arrays;
import utils.MyUtils;

public class Ex22_BinarySearchWithTrace {

  public static int rank(int[] a, int key) {
    return rank(a, key, 0, a.length - 1, 0);
  }

  private static int rank(int[] a, int key, int lo, int hi, int dep) {
    for (int i = 0; i < dep; ++i) {
      StdOut.print(" ");
    }
    StdOut.println("(lo: " + lo + ", hi: " + hi + ")");
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi - lo) / 2;
    if (a[mid] == key) {
      return mid;
    }
    if (a[mid] > key) {
      return rank(a, key, lo, mid - 1, dep + 1);
    }
    return rank(a, key, mid + 1, hi, dep + 1);
  }

  public static void main(String[] args) {
    StdRandom.setSeed(0);
    int[] arr = MyUtils.generateRandomArray(20, 1000);
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    // expected index = 18
    System.out.printf("Index of %d is %d\n", 875, rank(arr, 875));
  }

}
