// Add to the BinarySearch test client the ability to respond to a second argument:
// + to print numbers from standard input that are not in the whitelist, - to print
// numbers that are in the whitelist.

package ch1.section1;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import java.util.Arrays;

public class Ex23 {

  private static void runBinarySearchWithToggle(String[] args, char option) {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);

    // Read in numbers to search
    In fin = new In(args[1]);

    while (!fin.isEmpty()) { // Read key, print if not in whitelist.
      int key = fin.readInt();
      boolean found = BinarySearch.rank(key, whitelist) >= 0;
      if (option == '+' && !found) {
        StdOut.println(key);
      } else if (option == '-' && found) {
        StdOut.println(key);
      }
    }
  }

  public static void main(String[] args) {
    runBinarySearchWithToggle(args, '+');
  }

}
