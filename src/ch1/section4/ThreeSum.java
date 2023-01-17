package ch1.section4;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdRandom;

public class ThreeSum {

  public static void main(String[] args) {
    // performanceTest1();
    doublingTest();
  }

  private static void performanceTest1() {
    System.out.println(countTriples(new In("files/1Kints.txt").readAllInts()));
    System.out.println(countTriples(new In("files/2Kints.txt").readAllInts()));
    System.out.println(countTriples(new In("files/4Kints.txt").readAllInts()));
  }

  private static void doublingTest() {
    for (int i = 1000; i <= 20000; i *= 2) {
      int[] arr = new int[i];
      for (int j = 0; j < i; ++j) {
        arr[j] = StdRandom.uniform(-i, i + 1);
      }
      Stopwatch timer = new Stopwatch();
      System.out.println(countTriples(arr));
      System.out.println("Elapsed time for " + i + " input size: " + timer.elapsedTimeSec());
    }
  }

  public static int countTriples(int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; ++i) {
      for (int j = i + 1; j < arr.length; ++j) {
        for (int k = j + 1; k < arr.length; ++k) {
          if (arr[i] + arr[j] + arr[k] == 0) {
            ++count;
          }
        }
      }
    }
    return count;
  }
}