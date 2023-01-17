package ch1.section2;

import java.util.Locale;

public class Accumulator {

  private int fNumValues;
  private double fSum;

  public void addDataValue(double val) {
    fSum += val;
    ++fNumValues;
  }

  public double mean() {
    return fSum / fNumValues;
  }

  public String toString() {
    return "Mean (" + fNumValues + " values): " + String.format(new Locale("en"), "%7.5f", mean());
  }
}