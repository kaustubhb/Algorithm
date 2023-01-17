// Write a code fragment to print the transposition (rows and columns changed)
// of a two-dimensional array with M rows and N columns.

package ch1.section1;

public class Ex13_Transposition {

  public static int[][] transpose(final int[][] arr) {
    int m = arr.length;
    if (m == 0) {
      return arr;
    }
    int n = arr[0].length;
    int[][] result = new int[n][m];
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        result[j][i] = arr[i][j];
      }
    }
    return result;
  }
}
