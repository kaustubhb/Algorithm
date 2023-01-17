package ch1.section3;

import static ch1.section3.Ex10_InfixToPostfix.infixToPostfix;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Ex10InfixToPostfixTest {

  @Test
  public void testInfixToPostfix() {
    assertEquals("1 2 + 3 +", infixToPostfix("( ( 1 + 2 ) + 3 )"));
    assertEquals("1 2 * 3 +", infixToPostfix("( ( 1 * 2 ) + 3 )"));
    assertEquals("1 2 3 * +", infixToPostfix("( 1 + ( 2 * 3 ) )"));
    assertEquals("1 2 3 * 4 / + 5 +", infixToPostfix("( ( 1 + ( ( 2 * 3 ) / 4 ) ) + 5 )"));
    assertEquals("1", infixToPostfix("1"));
  }
}