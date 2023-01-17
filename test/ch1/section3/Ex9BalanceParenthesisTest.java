package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Ex9BalanceParenthesisTest {

  @Test
  public void testBalancedParenthesis() {
    assertEquals(Ex9_BalanceParenthesis.balanceParenthesis("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"),
        "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )");
    assertEquals(Ex9_BalanceParenthesis.balanceParenthesis("1 + 2 + 3 ) )"),
        "( 1 + ( 2 + 3 ) )");
    assertEquals(Ex9_BalanceParenthesis.balanceParenthesis("1 + 2 + 3 + 4 ) ) )"),
        "( 1 + ( 2 + ( 3 + 4 ) ) )");
  }
}