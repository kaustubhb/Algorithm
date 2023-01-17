// Equal keys. Add to BinarySearch a static method rank() that takes a key and
//  a sorted array of int values (some of which may be equal) as arguments and returns the
//  number of elements that are smaller than the key and a similar method count() that
//  returns the number of elements equal to the key. Note : If i and j are the values returned
//  by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in
//  the array that are equal to key.

package ch1.section1;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import java.util.Arrays;

public class Ex29_BinarySearchWithCount {

  // Find number of elements smaller than key. Return -1 if not found.
  public static int rank(int[] arr, int key) {
    int index = rankFirst(arr, key, 0, arr.length - 1);
    return index >= 0 ? index : -1;
  }

  // Find number of occurrences of key in the array.
  public static int count(int[] arr, int key) {
    int beg = rankFirst(arr, key, 0, arr.length - 1);
    if (beg < 0) {
      return 0;
    }
    int end = rankLast(arr, key, 0, arr.length - 1);
    return end - beg + 1;
  }

  // Returns the index of first occurrence of key, or negative of index where the element would be
  // inserted otherwise
  public static int rankFirst(int[] arr, int key) {
    return rankFirst(arr, key, 0, arr.length - 1);
  }

  // Returns the index of last occurrence of key, or negative of index where element might be inserted
  // otherwise.
  public static int rankLast(int[] arr, int key) {
    return rankLast(arr, key, 0, arr.length - 1);
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

  public static void main(String[] args) {
    String[] arg = new String[]{"files/whitelist_with_duplicates.txt", "files/ints_to_search.txt"};
    int[] whitelist = new In(arg[0]).readAllInts();
    int[] testList = new In(arg[1]).readAllInts();
    Arrays.sort(whitelist);

    for (int nxt : testList) {
      int idx = rank(whitelist, nxt);
      if (idx != -1) {
        StdOut.println("Index of " + nxt + " = " + idx + ",\tcount = " +
            count(whitelist, nxt));
      }
    }
  }

}
