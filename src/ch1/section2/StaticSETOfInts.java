package ch1.section2;

import java.util.Arrays;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class StaticSETOfInts {
  private final int[] fKeys;

  public StaticSETOfInts(int[] keys) {
    fKeys = new int[keys.length];
    for (int i = 0; i < keys.length; ++i) {
      fKeys[i] = keys[i];
    }
    Arrays.sort(fKeys);
  }

  public boolean contains(int k) {
    return binSearch(k, 0, fKeys.length - 1) != -1;
  }

  private int binSearch(int k, int lo, int hi) {
    if (hi < lo)
      return -1;
    int mid = lo + (hi - lo) / 2;
    if (fKeys[mid] < k)
      return binSearch(k, mid + 1, hi);
    if (fKeys[mid] > k)
      return binSearch(k, lo, mid - 1);
    return mid;
  }
}

class Whitelist {
  public static void main(String[] args) {
    In fin = new In("files/largeW.txt");
    int[] w = fin.readAllInts();
    StaticSETOfInts set = new StaticSETOfInts(w);
    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();
      if (!set.contains(i)) {
        StdOut.println(i + " not found");
      }
    }
  }
}