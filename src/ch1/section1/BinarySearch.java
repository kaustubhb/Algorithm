package ch1.section1;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import java.util.Arrays;

/**
 * Invoking the program % java BinarySearch files/tinyW.txt files/tinyT.txt
 */
public class BinarySearch {

  // Returns -1 if key not found
  public static int rank(int key, int[] a) { // Array must be sorted.
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) { // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        hi = mid - 1;
      } else if (key > a[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}

class BinarySearchClient {
  public static void main(String[] args) {
    runBinarySearch();
  }

  private static void runBinarySearch() {
    int[] whitelist = new In("files/largeW.txt").readAllInts();
    In fin = new In("files/largeT.txt");
    Arrays.sort(whitelist);
    while (!fin.isEmpty()) { // Read key, print if not in whitelist.
      int key = fin.readInt();
      if (BinarySearch.rank(key, whitelist) < 0) {
        StdOut.println(key);
      }
    }
  }
}