// Write a code fragment that creates an N-by-N boolean array a[][] such that a[i][j] is true
// if i and j are relatively prime (have no common factors), and false otherwise.

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;
import java.util.Arrays;
import utils.MyUtils;

public class Ex30_CoprimeGrid {

  private static boolean coprime(int a, int b) {
    return MyUtils.gcd(a, b) == 1;
  }

  public static void main(String[] args) {
    Ex30_CoprimeGrid client = new Ex30_CoprimeGrid();
    client.print2DArray(client.coprimeArray(20));
  }

  private void print2DArray(boolean[][] arr) {
    StdOut.println(Arrays.deepToString(arr)
        .replace("],", "\n")
        .replace(", ", "\t"));
  }

  private boolean[][] coprimeArray(int n) {
    boolean[][] arr = new boolean[n][n];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        arr[i][j] = coprime(i + 1, j + 1);
      }
    }
    return arr;
  }

}
