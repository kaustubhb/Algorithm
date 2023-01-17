// File input. Develop a possible implementation of the static readInts() method
// from In (which we use for various test clients, such as binary search on page 47) that
// is based on the split() method in String.

package ch1.section2;

import edu.princeton.cs.introcs.In;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex15_FileInput {

  public static void main(String[] args) {
    for (int i : readInts("files/e1_2_15.txt")) {
      System.out.println(i);
    }
  }

  public static int[] readInts(String fileName) {
    In fin = new In(fileName);
    List<Integer> ints = new ArrayList<>();
    while (fin.hasNextLine()) {
      String[] words = fin.readLine().split("\\s+");
      ints.addAll(Arrays.stream(words).map(Integer::parseInt).collect(Collectors.toList()));
    }
    return ints.stream().mapToInt(Integer::intValue).toArray();
  }
}
