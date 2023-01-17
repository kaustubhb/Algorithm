// Predict the output of foo(6)

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;

public class Ex16 {

  public static String foo(int n) {
    if (n <= 0) {
      return "";
    }
    return foo(n - 3) + n + foo(n - 2) + n;
  }

  // 131246

  public static void main(String[] args) {
    StdOut.println(foo(6).equals("311361142246"));
  }
}
