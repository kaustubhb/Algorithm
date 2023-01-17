// Closest pair (in one dimension). Write a program that, given an array a[] of N
// double values, finds a closest pair : two values whose difference is no greater than the
// the difference of any other pair (in absolute value). The running time of your program
// should be linearithmic in the worst case.

package ch1.section4;

import java.util.Arrays;

public class Ex16_ClosestPair {

  public static Pair closestPair(int[] arr) {
    if (arr.length < 2) {
      throw new IllegalArgumentException("Array should have at least 2 elements");
    }
    Arrays.sort(arr);
    int left = 0, right = 0;
    int minDiff = Integer.MAX_VALUE;
    int prev = 0;
    while (prev < arr.length - 1) {
      int current = prev + 1;
      int diff = arr[current] - arr[prev];
      if (diff < minDiff) {
        left = arr[prev];
        right = arr[current];
        minDiff = diff;
      }
      ++prev;
    }
    return new Pair(left, right);
  }

  static class Pair {

    int a;
    int b;

    public Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Pair pair = (Pair) o;
      return a == pair.a && b == pair.b;
    }
  }
}
