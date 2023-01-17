/* 1.1.11 Write a code fragment that prints the contents of a
two-dimensional boolean array, using * to represent true and a space
to represent false. Include row and column numbers.
 */

package ch1.section1;

public class Ex11_Print2DBooleanArray {

  public static String generateString(boolean[][] arr) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < arr.length; ++i) {
      for (int j = 0; j < arr[i].length; ++j) {
        result.append(arr[i][j] ? "* " : "  ");
      }
      if (i < arr.length - 1) {
        result.append("\n");
      }
    }
    return result.toString();
  }
}
