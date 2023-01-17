// Add an instance method howMany() to StaticSETofInts that finds the
// number of occurrences of a given key in time proportional to log N in the worst case.

package ch1.section4;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import java.util.Arrays;

public class Ex11_StaticSetOfInts {

  private final int[] fKeys;

  public Ex11_StaticSetOfInts(int[] keys) {
    fKeys = new int[keys.length];
    System.arraycopy(keys, 0, fKeys, 0, keys.length);
    Arrays.sort(fKeys);
  }

  private static int rankFirst(int[] arr, int key, int lo, int hi) {
    if (lo > hi) {
      return -lo;
    }
    int mid = lo + (hi - lo) / 2;
    if (arr[mid] > key) {
      return rankFirst(arr, key, lo, mid - 1);
    }
    if (arr[mid] < key) {
      return rankFirst(arr, key, mid + 1, hi);
    } else {
      if (mid == 0) {
        return 0;
      }
      if (arr[mid - 1] == key) {
        return rankFirst(arr, key, lo, mid - 1);
      } else {
        return mid;
      }
    }
  }

  private static int rankLast(int[] arr, int key, int lo, int hi) {
    if (lo > hi) {
      return -lo;
    }
    int mid = lo + (hi - lo) / 2;
    if (arr[mid] > key) {
      return rankLast(arr, key, lo, mid - 1);
    }
    if (arr[mid] < key) {
      return rankLast(arr, key, mid + 1, hi);
    } else {
      if (mid == arr.length - 1) {
        return mid;
      }
      if (arr[mid + 1] == key) {
        return rankLast(arr, key, mid + 1, hi);
      } else {
        return mid;
      }
    }
  }

  // Find number of occurrences of key in the array.
  public int howMany(int key) {
    int beg = rankFirst(fKeys, key, 0, fKeys.length - 1);
    if (beg < 0) {
      return 0;
    }
    int end = rankLast(fKeys, key, 0, fKeys.length - 1);
    return end - beg + 1;
  }

  public boolean contains(int k) {
    return rankFirst(fKeys, k, 0, fKeys.length - 1) >= 0;
  }
}

class Whitelist {

  public static void main(String[] args) {
    In fin = new In("files/largeW.txt");
    int[] w = fin.readAllInts();
    Ex11_StaticSetOfInts set = new Ex11_StaticSetOfInts(w);

    // test with 3, 27
    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();
      if (!set.contains(i)) {
        StdOut.println(i + " not found");
      } else {
        StdOut.println(set.howMany(i) + " occurrences of " + i + " found.");
      }
    }
  }

}
