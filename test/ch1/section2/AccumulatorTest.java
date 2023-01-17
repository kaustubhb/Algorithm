package ch1.section2;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccumulatorTest {

  @Test
  public void testAccumulator() {
    Accumulator acc = new Accumulator();
    int numValues = 100;

    StdRandom.setSeed(0);
    for (int i = 0; i < numValues; ++i) {
      acc.addDataValue(StdRandom.uniform());
    }
    Assertions.assertEquals(acc.toString(), "Mean (100 values): 0.54121");
  }

}
