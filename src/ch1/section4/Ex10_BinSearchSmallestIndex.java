// Modify binary search so that it always returns the element with the smallest
// index that matches the search element (and still guarantees logarithmic running time).

package ch1.section4;

public class Ex10_BinSearchSmallestIndex {

  public static int rankFirst(int[] arr, int key) {
    int index = rankFirst(arr, key, 0, arr.length - 1);
    return index >= 0 ? index : -1;
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
}
