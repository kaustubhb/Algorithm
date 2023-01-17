// Random connections. Write a program that takes as command-line arguments
// an integer N and a double value p (between 0 and 1), plots N equally spaced dots of size
// .05 on the circumference of a circle, and then, with probability p for each pair of points,
// draws a gray line connecting them.

package ch1.section1;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Ex31_RandomConnections {

  private static MyPoint getPosition(int i, int N, double r) {
    double theta = (double) i / N * 2 * Math.PI;
    return new MyPoint(r * Math.cos(theta), r * Math.sin(theta));
  }

  private static void drawCircle(double cx, double cy, double r) {
    StdDraw.setCanvasSize(500, 500);
    StdDraw.setXscale(0, 4 * r);
    StdDraw.setYscale(0, 4 * r);
    StdDraw.setPenRadius(0.005);

    StdDraw.circle(cx, cy, r);
  }

  private static void drawPointsOnCricle(double cx, double cy, double r, int N) {
    StdDraw.setPenRadius(0.01);
    for (int i = 0; i < N; ++i) {
      MyPoint point = getPosition(i, N, r);
      StdDraw.point(cx + point.x, cy + point.y);
    }
  }

  private static void joinPoints(double cx, double cy, double r, int N, double p) {
    StdDraw.setPenRadius(0.002);
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        if (StdRandom.bernoulli(p)) {
          MyPoint pi = getPosition(i, N, r);
          pi.x += cx;
          pi.y += cy;
          MyPoint pj = getPosition(j, N, r);
          pj.x += cx;
          pj.y += cy;

          StdDraw.line(pi.x, pi.y, pj.x, pj.y);
        }
      }
    }
  }

  public static void main(String[] args) {
    double cx, cy, r;
    cx = cy = 100;
    r = 50;
    drawCircle(cx, cy, r);

    StdOut.print("Number of points to plot? ");   // try 50
    int N = StdIn.readInt();
    StdOut.print("Probability to connect a pair of points? ");  // try 0.3
    double p = StdIn.readDouble();

    drawPointsOnCricle(cx, cy, r, N);
    joinPoints(cx, cy, r, N, p);
  }

  private static class MyPoint {

    public double x, y;

    public MyPoint(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

}
