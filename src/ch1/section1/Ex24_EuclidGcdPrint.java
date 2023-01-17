// Develop a program that takes two integers from the command
//  line and computes their greatest common divisor, printing out the two arguments for
//  each call on the recursive method. Use your program to compute the greatest common
//  divisor or 1111111 and 1234567.

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;

public class Ex24_EuclidGcdPrint {

  public static void main(String[] args) {
    StdOut.println(new Ex24_EuclidGcdPrint().gcdEuclidPrint(1111111, 1234567));
    StdOut.println("===========");
    StdOut.println(new Ex24_EuclidGcdPrint().gcdEuclidPrint(12, 42));
  }

  public int gcdEuclidPrint(int a, int b) {
    return gcdEuclidPrint(a, b, 0);
  }

  public int gcdEuclidPrint(int a, int b, int dep) {
    for (int i = 0; i < dep; ++i) {
      StdOut.print(" ");
    }
    StdOut.println("(" + a + ", " + b + ")");

    if (a % b == 0) {
      return b;
    }
    return gcdEuclidPrint(b, a % b, ++dep);
  }
}
