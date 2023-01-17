package ch1.section2;

public class Interval1D {

  double fMin, fMax;

  public Interval1D(double lo, double hi) {
    fMin = Math.min(lo, hi);
    fMax = Math.max(lo, hi);
  }

  public double left() {
    return fMin;
  }

  public double right() {
    return fMax;
  }

  public double length() {
    return fMax - fMin;
  }

  public boolean contains(double x) {
    return x >= fMin && x <= fMax;
  }

  public boolean intersects(Interval1D that) {
    if (this.right() < that.left()) {
      return false;
    }
    return !(this.left() > that.right());
  }

  public String toString() {
    return "(" + fMin + ", " + fMax + ")";
  }
}