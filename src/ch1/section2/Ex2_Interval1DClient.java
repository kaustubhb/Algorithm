//  Write an Interval1D client that takes an int value N as command-line argument,
//  reads N intervals (each defined by a pair of double values) from standard input,
//  and prints all pairs that intersect.

package ch1.section2;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Ex2_Interval1DClient {

  public static void main(String[] args) {
    StdOut.print("Number of intervals: ");
    int n = StdIn.readInt();
    Interval1D[] intervals = new Interval1D[n];
    for (int i = 0; i < n; ++i) {
      StdOut.print("Interval " + i + ": ");
      double x1 = StdIn.readDouble();
      double x2 = StdIn.readDouble();
      intervals[i] = new Interval1D(x1, x2);
    }

    for (int i = 1; i < n; ++i) {
      for (int j = 0; j < i; ++j) {
        if (intervals[j].intersects(intervals[i])) {
          StdOut.println("Intervals " + intervals[j] + " and " + intervals[i] + " intersect");
        }
      }
    }
  }
}
