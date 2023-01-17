package ch1.section1;

import edu.princeton.cs.introcs.In;
import java.util.Arrays;

public class Ex38 {

  private static int bruteForceRank(int key, int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (key == arr[i]) {
        return i;
      }
    }
    return -1;
  }

  private static void bruteForceSearchClient(int[] numbers, int[] toSearch) {
    int[] indexList = new int[toSearch.length];
    for (int i = 0; i < toSearch.length; i++) {
      indexList[i] = bruteForceRank(toSearch[i], numbers);
    }
  }

  private static void binarySearchClient(int[] numbers, int[] toSearch) {
    int[] indexList = new int[toSearch.length];
    for (int i = 0; i < toSearch.length; i++) {
      indexList[i] = BinarySearch.rank(toSearch[i], numbers);
    }
  }

  public static void main(String[] args) {
    int[] numbers = new In("files/largeW.txt").readAllInts();
    int[] toSearch = new In("files/largeT.txt").readAllInts();

    Arrays.sort(numbers);
    long t1 = System.nanoTime();
    binarySearchClient(numbers, toSearch);
    long t2 = System.nanoTime();
    long d = (t2 - t1)/1000000;
    System.out.printf("Binary search client finished in %d ms", d);   // Finishes in < 300ms

    t1 = System.nanoTime();
    bruteForceSearchClient(numbers, toSearch);
    t2 = System.nanoTime();
    d = (t2 - t1)/1000000;
    System.out.printf("Brute search client finished in %d ms", d); // Doesn't finish in 1 minute
  }
}
