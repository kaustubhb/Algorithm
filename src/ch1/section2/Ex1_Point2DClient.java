//  Write a Point2D client that takes an integer value N from the command line,
//  generates N random points in the unit square, and computes the distance separating
//  the closest pair of points.

package ch1.section2;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

class Point2DClient {

  public static void main(String[] args) {
    StdOut.print("Number of random points: ");  // Try 100
    int n = StdIn.readInt();
    assert (n >= 2);
    Point2D[] points = new Point2D[n];

    StdDraw.setCanvasSize(500, 500);
    StdDraw.setXscale(0, 1.0);
    StdDraw.setYscale(0, 1.0);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(0.005);
    double minDist = Math.sqrt(2);   // max possible distance

    Point2D minPoint1 = null, minPoint2 = null;
    for (int i = 0; i < n; ++i) {
      points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
      points[i].draw();
      for (int j = 0; j < i; ++j) {
        double dist = points[i].distTo(points[j]);
        if (dist < minDist) {
          minDist = dist;
          minPoint1 = points[j];
          minPoint2 = points[i];
        }
      }
    }
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.01);
    StdOut.println("Minimum distance = " + minDist);
    minPoint1.draw();
    minPoint2.draw();
  }
}