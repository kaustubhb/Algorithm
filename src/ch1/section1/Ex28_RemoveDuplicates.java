// Remove any duplicate keys in the whitelist after the sort

package ch1.section1;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ex28_RemoveDuplicates {

  public static int[] removeDuplicatesNewList(int[] whitelist) {
    if (whitelist.length > 0) {
      ArrayList<Integer> result = new ArrayList<>();
      result.add(whitelist[0]);
      for (int i = 1; i < whitelist.length; ++i) {
        if (whitelist[i] != whitelist[i - 1]) {
          result.add(whitelist[i]);
        }
      }
      int[] ret = new int[result.size()];
      for (int i = 0; i < result.size(); ++i) {
        ret[i] = result.get(i);
      }
      return ret;
    }
    return new int[0];
  }

  // Remove duplicates in-place, O(n) algorithm
  public static List<Integer> removeDuplicatesInPlace(List<Integer> whitelist) {
    if (whitelist.size() <= 1) {
      return whitelist;
    }
    int i = 1, placesToMoveBack = 0;
    while (i < whitelist.size()) {
      if (Objects.equals(whitelist.get(i), whitelist.get(i - 1))) {
        ++placesToMoveBack;
      } else {
        whitelist.set(i - placesToMoveBack, whitelist.get(i));
      }
      ++i;
    }
    whitelist.subList(i - placesToMoveBack, whitelist.size()).clear();
    System.out.println(whitelist.size());
    return whitelist;
  }

  public static void main(String[] args) {
    int[] whitelist = new In("files/tinyT.txt").readAllInts();
    Arrays.sort(whitelist);

    StdOut.println("Array size: " + whitelist.length);
    whitelist = removeDuplicatesNewList(whitelist);
    StdOut.println("Array size after removing duplicates: " + whitelist.length);
  }
}
