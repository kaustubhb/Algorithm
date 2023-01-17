//  Write an Interval2D client that takes command-line arguments N, min, and max
//	and generates N random 2D intervals whose width and height are uniformly distributed
//	between min and max in the unit square. Draw them on StdDraw and print the number
//	of pairs of intervals that intersect and the number of intervals that are contained in one
//	another

package ch1.section2;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

class Ex3_Interval2DClient {

  public static void main(String[] args) {
    StdOut.println("This program generates random intervals and draws them.");
    StdOut.print("Number of intervals: ");
    int n = StdIn.readInt();
    StdOut.print("Min width/height (0-1.0): ");
    double min = StdIn.readDouble();
    StdOut.print("Max width/height (0-1.0): ");
    double max = StdIn.readDouble();

    StdDraw.setCanvasSize(500, 500);
    StdDraw.setXscale(0, 1);
    StdDraw.setYscale(0, 1);

    Interval2D[] intervals = new Interval2D[n];
    int numInterSections = 0;
    int numContains = 0;

    for (int i = 0; i < n; ++i) {
      double width = StdRandom.uniform(min, max);
      double height = StdRandom.uniform(min, max);
      double x = StdRandom.uniform(0, 1 - width);
      double y = StdRandom.uniform(0, 1 - height);
      intervals[i] = new Interval2D(new Interval1D(x, x + width),
          new Interval1D(y, y + height));
      intervals[i].draw();
      for (int j = 0; j < i; ++j) {
        if (intervals[j].intersects(intervals[i])) {
          ++numInterSections;
        }
        if (intervals[j].contains(intervals[i]) ||
            intervals[i].contains(intervals[j])) {
          ++numContains;
        }
      }
    }
    StdOut.println("Number of intersections: " + numInterSections);
    StdOut.println("Number of intervals contained in one another: " + numContains);
  }
}