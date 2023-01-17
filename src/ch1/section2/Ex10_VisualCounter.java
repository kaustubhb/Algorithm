//  Develop a class VisualCounter that allows both increment and decrement
//	operations. Take two arguments N and max in the constructor, where N specifies the
//	maximum number of operations and max specifies the maximum absolute value for
//	the counter. As a side effect, create a plot showing the value of the counter each time its
//	tally changes.

package ch1.section2;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

public class Ex10_VisualCounter {

  private int fTally;
  private int fCountOps;
  private final int fMaxVal;

  public Ex10_VisualCounter(int n, int max) {
    fTally = 0;
    fCountOps = 0;
    fMaxVal = max;
    StdDraw.setCanvasSize(500, 500);
    StdDraw.setXscale(0, n);
    StdDraw.setYscale(0, fMaxVal * 2 + 1);
    StdDraw.setPenRadius(0.005);
  }

  public void increment() {
    if (fTally < fMaxVal) {
      ++fTally;
      StdDraw.point(fCountOps++, fTally + fMaxVal + 1);
    } else {
      System.err.println("Can't increment beyond maximum value");
    }

  }

  public void decrement() {
    if (fTally > -fMaxVal) {
      --fTally;
      StdDraw.point(fCountOps++, fTally + fMaxVal + 1);
    } else {
      System.err.println("Can't decrement beyond minimum value");
    }
  }

  public int tally() {
    return fTally;
  }
}

class TestVisualCounter {

  public static void main(String[] args) {
    // 1000 operations
    int MAX_OPS = 1000;
    Ex10_VisualCounter vc = new Ex10_VisualCounter(MAX_OPS, (int) MAX_OPS / 2);
    for (int i = 0; i < MAX_OPS; ++i) {
      if (StdRandom.bernoulli(0.7)) {
        vc.increment();
      } else {
        vc.decrement();
      }
    }
  }
}