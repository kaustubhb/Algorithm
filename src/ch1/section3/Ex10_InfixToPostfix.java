/* Write a filter Ex10_InfixToPostfix that converts an arithmetic expression from
 * infix to postfix.*/

/* Assumption:
 * Infix expression is fully parenthesised
 * E.g. ( ( 1 + 2 ) * 3 ) is valid but
 * 1 + 2 * 3 is not
 */

package ch1.section3;

public class Ex10_InfixToPostfix {

  public static String infixToPostfix(String input) {
    String[] tokens = input.split("\\s");
    Stack<String> stack = new Stack<>();

    for (String tok : tokens) {
      switch (tok) {
        case ")":
          String b = stack.pop();
          String op = stack.pop();
          String a = stack.pop();
          String subExpr = String.format("%s %s %s", a, b, op);
          stack.push(subExpr);
          break;
        case "+":
        case "-":
        case "*":
        case "/":
          stack.push(tok);
          break;
        case "(":
          break;
        default:
          if (!tok.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid token in infix expression");
          }
          stack.push(tok);
      }
    }
    return stack.pop();
  }
}
