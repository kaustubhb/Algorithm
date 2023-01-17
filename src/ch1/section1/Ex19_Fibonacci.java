/* What is the largest value of N for which this program takes less 1 hour to compute the
value of F(N)? Develop a better implementation of F(N) that saves computed values in
an array.
 */

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;

public class Ex19_Fibonacci {

  static long[] cache = new long[100];

  public static long computeSlow(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return computeSlow(n - 1) + computeSlow(n - 2);
  }

  // Cannot compute beyond fib(92) due to overflow.
  public static long computeFast(int n) {
    if (n == 0 || n == 1) {
      cache[n] = n;
      return n;
    }
    if (cache[n] != 0) {
      return cache[n];
    }
    long result = computeFast(n - 1) + computeFast(n - 2);
    cache[n] = result;
    return result;
  }

  public static void main(String[] args) {
    StdOut.println("Fast method");
    for (int n = 0; n < 100; n++) {
      StdOut.println(n + " " + computeFast(n));
    }
    // Kill after 44
    StdOut.println("Now slow method");
    for (int n = 0; n < 100; n++) {
      StdOut.println(n + " " + computeSlow(n));
    }
  }
}

// slow method takes > 1 min to calculate 47th number
