// Instrument BinarySearch to use a Counter to count the total number of keys examined during all
// searches and then print the total after all searches are complete.

package ch1.section2;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import java.util.Arrays;

public class Ex9_InstrumentBinarySearch {
  public static int rank(int key, int[] a, Counter counter) { // Array must be sorted.
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) { // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      counter.increment();
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

  private static void runBinarySearch() {
    int[] whitelist = new In("files/largeW.txt").readAllInts();
    In fin = new In("files/largeT.txt");
    Arrays.sort(whitelist);
    Counter comparisonsCounter = new Counter("comparison");
    while (!fin.isEmpty()) { // Read key, print if not in whitelist.
      int key = fin.readInt();
      if (rank(key, whitelist, comparisonsCounter) < 0) {
        StdOut.println(key);
      }
    }
    StdOut.println(comparisonsCounter);
  }

  public static void main(String[] args) {
    runBinarySearch();
  }
}
