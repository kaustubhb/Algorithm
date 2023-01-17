/* 1.1.3 Write a program that takes three integer command-line arguments and prints
 * equal if all three are equal, and not equal otherwise.
 */

package ch1.section1;

public class Ex3 {

  public static void main(String[] args) {
    if (args.length != 3) {
      System.err.println("3 command line arguments required");
      return;
    }
    try {
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      int c = Integer.parseInt(args[2]);
      System.out.println(a == b && b == c ? "Equal" : "Not Equal");
    } catch (NumberFormatException ex) {
      System.err.println("Integers expected");
    }
  }
}
