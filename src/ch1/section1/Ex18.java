// What are the values of mystery(2, 25) and mystery(3, 11)? Given positive integers
// a and b, describe what value mystery(a, b) computes.
// Answer the same question, but replace + with * and replace return 0 with return 1.


package ch1.section1;

import edu.princeton.cs.introcs.StdOut;

public class Ex18 {

  public static int mystery(int a, int b) {
    if (b == 0) {
      return 0;
    }
    if (b % 2 == 0) {
      return mystery(a + a, b / 2);
    }
    return mystery(a + a, b / 2) + a;
  }

  public static int mystery2(int a, int b) {
    if (b == 0) {
      return 1;
    }
    if (b % 2 == 0) {
      return mystery2(a * a, b / 2);
    } else {
      return mystery2(a * a, b / 2) * a;
    }
  }

  // All invocations should print true
  public static void main(String[] args) {
    StdOut.println(mystery(2, 25) == 50);
    StdOut.println(mystery(3, 11) == 33);

    StdOut.println(mystery2(3, 4) == 81);
    StdOut.println(mystery2(2, 7) == 128);
  }
}

/* mystery(a, b) Multiplies a and b
 * (a * b) is equivalent to
 *    (2*a * b/2) if b is even, or
 *    (2*a * b/2) + a if b is odd
 *
 * Similarly, mystery2(a, b) computes a^b
 */
