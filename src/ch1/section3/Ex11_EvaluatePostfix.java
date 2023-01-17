/* Write a program Ex11_EvaluatePostfix that takes a postfix expression from standard input,
 * evaluates it, and prints the value.
 */

package ch1.section3;

import java.util.Arrays;

public class Ex11_EvaluatePostfix {

  private static boolean isOperator(String tok) {
    return Arrays.asList(new String[]{"+", "-", "*", "/"}).contains(tok);
  }

  private static boolean isNumber(String tok) {
    try {
      Integer.parseInt(tok);
      return true;
    } catch (NumberFormatException ex) {
      return false;
    }
  }

  public static int evaluate(String postfix) {
    String[] tokens = postfix.split("\\s+");
    Stack<Integer> stack = new Stack<>();

    for (String tok : tokens) {
      if (isNumber(tok)) {
        stack.push(Integer.parseInt(tok));
      } else if (isOperator(tok)) {
        if (stack.size() < 2) {
          throw new IllegalArgumentException("Malformed postfix expression");
        }
        int b = stack.pop();
        int a = stack.pop();
        int val = 0;
        switch (tok) {
          case "+":
            val = a + b;
            break;
          case "-":
            val = a - b;
            break;
          case "*":
            val = a * b;
            break;
          default:
            if (b == 0) {
              throw new ArithmeticException("Division by zero");
            }
            val = a / b;
            break;
        }
        stack.push(val);
      } else {
        throw new IllegalArgumentException("Malformed postfix expression");
      }
    }
    return stack.pop();
  }
}
