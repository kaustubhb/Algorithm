/*1.1.5 Write a code fragment that prints true if the double variables x and y are both
strictly between 0 and 1 and false otherwise.
 */

package ch1.section1;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Ex5 {

  public static void main(String[] args) {
    double x, y;
    StdOut.println("Enter 2 double values.");
    x = StdIn.readDouble();
    y = StdIn.readDouble();
    StdOut.println(x >= 0 && x <= 1.0 && y >= 0 && y <= 1.0 ? "True" : "False");
  }
}
