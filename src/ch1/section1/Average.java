package ch1.section1;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Average {

  public static void main(String[] args) {
    double sum = 0;
    int count = 0;
    StdOut.println("Enter a few numbers to calculate average.");
    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();
      sum += i;
      ++count;
    }
    StdOut.println("Average: " + sum / count);
  }
}
