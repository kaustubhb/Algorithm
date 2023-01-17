package ch1.section2;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Interval2D {

  private final Interval1D fXInterval;
  private final Interval1D fYInterval;

  public Interval2D(Interval1D xInterval, Interval1D yInterval) {
    fXInterval = xInterval;
    fYInterval = yInterval;
  }

  public double area() {
    return fXInterval.length() * fYInterval.length();
  }

  public boolean contains(Point2D p) {
    return fXInterval.contains(p.x()) && fYInterval.contains(p.y());
  }

  public boolean intersects(Interval2D that) {
    return this.fXInterval.intersects(that.fXInterval) &&
        this.fYInterval.intersects(that.fYInterval);
  }

  public boolean contains(Interval2D that) {
    return this.contains(new Point2D(that.fXInterval.left(), that.fYInterval.left())) &&
        this.contains(new Point2D(that.fXInterval.right(), that.fYInterval.left())) &&
        this.contains(new Point2D(that.fXInterval.left(), that.fYInterval.right())) &&
        this.contains(new Point2D(that.fXInterval.right(), that.fYInterval.right()));
  }

  public void draw() {
    double xc = (fXInterval.left() + fXInterval.right()) / 2;
    double yc = (fYInterval.left() + fYInterval.right()) / 2;
    double hfx = fXInterval.length() / 2;
    double hfy = fYInterval.length() / 2;
    StdDraw.rectangle(xc, yc, hfx, hfy);
  }

  public String toString() {
    return fXInterval + " x " + fYInterval;
  }
}

class Interval2DClient {

  public static void main(String[] args) {
    // Read from standard input box's location
    StdOut.println("Enter box's location (xlo, xhi, ylo, yhi), values from 0 to 1");
    double xlo = StdIn.readDouble();
    double xhi = StdIn.readDouble();
    double ylo = StdIn.readDouble();
    double yhi = StdIn.readDouble();

    // Read in number of points
    StdOut.print("Number of points? ");
    int numPoints = StdIn.readInt();

    Interval1D xInt = new Interval1D(xlo, xhi);
    Interval1D yInt = new Interval1D(ylo, yhi);

    Interval2D int2d = new Interval2D(xInt, yInt);
    int2d.draw();

    double area = 0;
    for (int i = 0; i < numPoints; ++i) {
      Point2D p = new Point2D(StdRandom.uniform(), StdRandom.uniform());
      if (int2d.contains(p)) {
        ++area;
      } else {
        StdDraw.point(p.x(), p.y());
      }
    }
    area /= numPoints;
    StdOut.println("Area of box = " + area);
  }
}