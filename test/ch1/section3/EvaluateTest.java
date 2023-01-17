package ch1.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluateTest {

  @Test
  public void testEvaluate() {
    Assertions.assertEquals(-3.0, Evaluate.evaluate("( ( 1 + 2 ) * ( 5 - 6 ) )"), 0.000001);
    Assertions.assertEquals(3.0, Evaluate.evaluate("( ( 10 + 20 ) / 10 )"), 0.000001);
  }
}