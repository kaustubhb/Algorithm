package ch1.section2;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class VisualAccumulator {

  int fN;
  double fSum;

  public VisualAccumulator(int nTrials, double maxVal) {
    StdDraw.setCanvasSize(500, 500);
    StdDraw.setXscale(0, nTrials);
    StdDraw.setYscale(0, maxVal);
    StdDraw.setPenRadius(0.005);
  }

  public void addDataValue(double val) {
    fSum += val;
    StdDraw.setPenColor(StdDraw.DARK_GRAY);
    StdDraw.point(fN++, val);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.point(fN, mean());
  }

  public double mean() {
    return fSum / fN;
  }

  public String toString() {
    return "Mean (" + fN + " values): " + String.format("%7.5f", mean());
  }
}

class VisualAccumulatorDriver {

  public static void main(String[] args) {
    System.out.print("Number of points to generate? ");   // Try 1000
    int numValues = StdIn.readInt();
    VisualAccumulator a = new VisualAccumulator(numValues, 1.0);

    for (int i = 0; i < numValues; ++i) {
      a.addDataValue(StdRandom.uniform());
    }
    StdOut.println(a);
  }
}