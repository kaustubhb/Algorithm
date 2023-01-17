package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Ex4CheckParenthesisTest {

  @Test
  public void testIsBalanced() {
    var client = new Ex4_CheckParenthesis();
    assertTrue(client.isBalanced("[()]{}{[()()]()}"));
    assertTrue(client.isBalanced(""));
    assertTrue(client.isBalanced("(){} [ ]({ })"));
    assertFalse(client.isBalanced("(()"));
    assertFalse(client.isBalanced("[(])"));
  }
}