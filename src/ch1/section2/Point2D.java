package ch1.section2;

import edu.princeton.cs.introcs.StdDraw;

public class Point2D {

  double x, y;

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double x() {
    return x;
  }

  public double y() {
    return y;
  }

  public double r() {
    return Math.sqrt(x * x + y * y);
  }

  public double theta() {
    return Math.atan(y / x);
  }

  public double distTo(Point2D that) {
    return Math.sqrt(square(this.x - that.x)
        + square(this.y - that.y));
  }

  public void draw() {
    StdDraw.point(x(), y());
  }

  private double square(double d) {
    return d * d;
  }
}