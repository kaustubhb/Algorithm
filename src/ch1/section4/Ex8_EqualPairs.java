// Write a program to determine the number pairs of values in an input file that
// are equal.

package ch1.section4;

import java.util.Collections;
import java.util.List;

public class Ex8_EqualPairs {

  public static int countEqualPairs(List<Integer> arr) {
    if (arr.isEmpty()) {
      return 0;
    }
    Collections.sort(arr);
    int equalPairs = 0;
    int fIndex = 0, lIndex = 0;
    while (lIndex < arr.size()) {
      if (!arr.get(lIndex).equals(arr.get(fIndex))) {
        int numEqual = lIndex - fIndex;
        equalPairs += numEqual * (numEqual - 1) / 2;
        fIndex = lIndex;
      }
      ++lIndex;
    }
    int numEqual = lIndex - fIndex;
    equalPairs += numEqual * (numEqual - 1) / 2;

    return equalPairs;
  }
}
