/* Write a program that takes from standard input an expression without left parentheses
 * and prints the equivalent infix expression with the parentheses inserted. For example,
 * given the input:
 * 		1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * 		( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 * */

package ch1.section3;

public class Ex9_BalanceParenthesis {

  public static String balanceParenthesis(String expr) {
    Stack<String> subExpressions = new Stack<>();
    String[] tokens = expr.split("\\s");
    for (String tok : tokens) {
      if (!tok.equals(")")) {
        subExpressions.push(tok);
      } else {
        String b = subExpressions.pop();
        String op = subExpressions.pop();
        String a = subExpressions.pop();
        String subExpr = String.format("( %s %s %s )", a, op, b);
        subExpressions.push(subExpr);
      }
    }
    return subExpressions.pop();
  }

  public static void main(String[] args) {
    System.out.println(Ex9_BalanceParenthesis.balanceParenthesis("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"));
  }

}
