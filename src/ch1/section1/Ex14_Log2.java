// Write a static method lg() that takes an int value N as argument and returns
// the largest int not larger than the base-2 logarithm of N. Do not use Math.

package ch1.section1;

public class Ex14_Log2 {

  public static int log2(int N) {
    if(N <= 0) {
      throw new IllegalArgumentException("Argument must be positive integer.");
    }
    int power = 1;
    int i = 0;
    while (power <= N) {
      power *= 2;
      ++i;
    }
    return i - 1;
  }

}
