package ch1.section4;

import ch1.section1.BinarySearch;
import edu.princeton.cs.introcs.In;
import java.util.Arrays;

public class ThreeSumFast {

  public static int countTriples(int[] arr) {
    Arrays.sort(arr);
    int count = 0;
    for (int i = 0; i < arr.length; ++i) {
      for (int j = i + 1; j < arr.length; ++j) {
        int rank = BinarySearch.rank(-arr[i] - arr[j], arr);
        if (rank > j) {
          ++count;
        } else if (rank > 0) {
          break;
        }
      }
    }
    return count;
  }

  private static void performanceTest1() {
    System.out.println(countTriples(new In("files/1Kints.txt").readAllInts()));
    System.out.println(countTriples(new In("files/2Kints.txt").readAllInts()));
    System.out.println(countTriples(new In("files/4Kints.txt").readAllInts()));
    System.out.println(countTriples(new In("files/8Kints.txt").readAllInts()));
    System.out.println(countTriples(new In("files/32Kints.txt").readAllInts()));
  }

  public static void main(String[] args) {
    performanceTest1();
  }
}
