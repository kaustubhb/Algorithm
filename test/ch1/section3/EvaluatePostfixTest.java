package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EvaluatePostfixTest {

  @Test
  public void evaluate() {
    assertEquals(Ex11_EvaluatePostfix.evaluate("1 2 + 3 +"), 6);
    assertEquals(Ex11_EvaluatePostfix.evaluate("1 2 * 3 +"), 5);
    assertEquals(Ex11_EvaluatePostfix.evaluate("1 2 3 * +"), 7);
    assertEquals(Ex11_EvaluatePostfix.evaluate("1 2 3 * 4 / + 5 +"), 7);
  }
}