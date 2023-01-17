// Predict output for each function

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;

public class Ex7 {

  static void foo() {
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) {
      t = (9.0 / t + t) / 2.0;
    }
    StdOut.printf("%.5f\n", t);
  }
  /* Newton's method to calculate square root of 9 */

  static void bar() {
    int sum = 0;
    for (int i = 1; i < 1000; i++) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    StdOut.println(sum);
  }
  // 499500 = Sum of first 999 natural numbers

  static void baz() {
    int sum = 0;
    for (int i = 1; i < 1000; i *= 2) {
      for (int j = 0; j < 1000; j++) {
        sum++;
      }
    }
    StdOut.println(sum);
  }
  // 10,000

  public static void main(String[] args) {
    foo();
    bar();
    baz();
  }

}
