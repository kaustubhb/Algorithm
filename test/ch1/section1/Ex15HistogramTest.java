package ch1.section1;

import static org.junit.jupiter.api.Assertions.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.jupiter.api.Test;

class Ex15HistogramTest {

  @Test
  public void testHistogram() {
    int len = 100;
    int m = 20;
    int[] a = new int[len];

    for (int i = 0; i < len; ++i) {
      a[i] = StdRandom.uniform(m);
    }
    int[] b = Ex15_Histogram.histogram(a, m);
    int sum = 0;
    for (int j : b) {
      sum += j;
    }
    assertEquals(sum, a.length);
  }
}