//  Random matches. Write a BinarySearch client that takes an int value T as
//  command-line argument and runs T trials of the following experiment for N = 10^3, 10^4,
//  10^5, and 10^6:
//  Generate two arrays of N randomly generated positive six-digit int values,
//  and find the number of values that appear in both arrays. Print a table giving the average
//  value of this quantity over the T trials for each value of N.

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import java.util.Arrays;

class Ex39_RandomMatches {

  static int runExperiment(int n, int low, int high) {
    int[] a1 = generateSortedRandomArray(n, low, high);
    int[] a2 = generateSortedRandomArray(n, low, high);
    return countDuplicates(a1, a2);
  }

  // Return number of common elements between the 2 arrays.
  // If an element x occurs a times in array1 and b times in array2, then x will be counted
  // min(a, b) times.
  static int countDuplicates(int[] a1, int[] a2) {
    int n = a1.length;
    int nDuplicates = 0;
    int j = 0;
    for (int i = 0; i < n; ++i) {
      int toFind = a1[i];
      // find number of elements in a1 which are equal to toFind
      int a = 1;
      while (i + a < n && a1[i + a] == toFind) {
        ++a;
      }
      i += a - 1;

      while (j < n && a2[j] < toFind) {
        ++j;
      }
      // find number of elements in a2 which are equal to toFind
      int b = 0;
      while (j + b < n && a2[j + b] == toFind) {
        ++b;
      }
      nDuplicates += Math.min(a, b);
      if (j > n) {
        break;
      }
    }
    return nDuplicates;
  }

  // generate series of n random integers in [low,high).
  static int[] generateSortedRandomArray(int n, int low, int high) {
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = StdRandom.uniform(low, high);
    }
    Arrays.sort(arr);
    return arr;
  }

  public static void main(String[] args) {
    int T = 10;
    StdRandom.setSeed(0);

    int lo = 100000, hi = 1000000;
    int[] trialNs = new int[]{1000, 10000, 100000, 1000000};

    for (int trialN : trialNs) {
      double nDupsAvg = 0;
      for (int j = 0; j < T; ++j) {
        nDupsAvg += 1.0 * runExperiment(trialN, lo, hi) / T;
      }
      StdOut.println("(trials:" + trialN + ", " + lo + ", " + hi + "): " + nDupsAvg);
    }
  }
}