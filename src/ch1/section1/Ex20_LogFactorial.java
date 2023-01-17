// Write a recursive static method that computes the value of ln(N!)

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;

public class Ex20_LogFactorial {

  public static double compute(int n) {
    if (n < 1) {
      throw new IllegalArgumentException("Argument should be >= 1");
    }
    if (n == 1) {
      return 0;
    }
    return Math.log(n) + compute(n - 1);
  }

  private static boolean closeEnough(double a, double b, double eps) {
    return Math.abs(a-b) < eps;
  }

  public static void main(String[] args) {
    StdOut.println(closeEnough(compute(10), 15.104, 0.01));
    StdOut.println(closeEnough(compute(100), 363.739, 0.01));
  }
}
