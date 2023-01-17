package ch1.section4;

import edu.princeton.cs.introcs.StdRandom;
import java.util.function.BiFunction;

public class DoublingTestForThreeSum {

  public static double timeTrialThreeSum(int n, int max) {
    int[] a = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = StdRandom.uniform(-max, max);
    }
    Stopwatch timer = new Stopwatch();
    ThreeSum.countTriples(a);
    return timer.elapsedTimeSec();
  }

  public static double timeTrialThreeSumFast(int n, int max) {
    int[] a = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = StdRandom.uniform(-max, max);
    }
    Stopwatch timer = new Stopwatch();
    ThreeSumFast.countTriples(a);
    return timer.elapsedTimeSec();
  }

  public static void doublingRatio(BiFunction<Integer, Integer, Double> bfn) {
    double prev = bfn.apply(125, 125 * 10);
    for (int n = 250; n < 20000; n *= 2) {
      double time = bfn.apply(n, n * 10);
      System.out.printf("%7d %7.2f %6.2f\n", n, time, time / prev);
      prev = time;
    }
  }

  public static void main(String[] args) {
    System.out.println("Doubling test for 3-sum fast");
    doublingRatio(DoublingTestForThreeSum::timeTrialThreeSumFast);

    System.out.println("\nDoubling test for 3-sum");
    doublingRatio(DoublingTestForThreeSum::timeTrialThreeSum);

  }

}
