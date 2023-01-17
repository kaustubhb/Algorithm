//  Histogram. Suppose that the standard input stream is a sequence of double
//  values. Write a program that takes an integer N and two double values l and r from the
//  command line and uses StdDraw to plot a histogram of the count of the numbers in the
//  standard input stream that fall in each of the N intervals defined by dividing (l , r) into
//  N equal-sized intervals.

package ch1.section1;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Ex32_Histogram {

  public static void drawHistogram(int numIntervals, int[] sample, int lo, int hi) {
    StdDraw.setCanvasSize(500, 500);
    StdDraw.setXscale(0, 1.0);
    StdDraw.setYscale(0, 1.0);

    int maxFreq = 0;
    double bucketSize = 1.0 * (hi - lo) / numIntervals;
    int[] frequency = new int[numIntervals];
    for (int j : sample) {
      int bucket = (int) Math.floor((j - lo) / bucketSize);
      frequency[bucket]++;
      if (frequency[bucket] > maxFreq) {
        maxFreq = frequency[bucket];
      }
    }

    double heightMultiplier = 0.75 / maxFreq;

    // Now draw histograms
    for (int i = 0; i < numIntervals; ++i) {
      double height = heightMultiplier * frequency[i];
      double width = 1.0 / (1.5 * numIntervals + 0.5);
      double xcoord = (1.5 * i + 1) * width;
      double ycoord = height / 2;
      StdDraw.filledRectangle(xcoord, ycoord, width / 2, height / 2);
    }
  }

  public static void main(String[] args) {
    int numIntervals;
    int lo, hi;
    StdOut.print("Number range (lo, hi): ");  // try 0 100
    lo = StdIn.readInt();
    hi = StdIn.readInt();
    StdOut.print("Number of buckets: ");      // try 20
    numIntervals = StdIn.readInt();
    StdOut.print("Number of data points: ");  // try 1000
    int sampleSize = StdIn.readInt();

    int[] sample = new int[sampleSize];
    for (int i = 0; i < sampleSize; ++i) {
      sample[i] = StdRandom.uniform(lo, hi);
    }
    drawHistogram(numIntervals, sample, lo, hi);
  }

}
