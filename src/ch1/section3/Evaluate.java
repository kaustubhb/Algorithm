// Dijkstra's 2-stack algo for "fully parenthesized" expression evaluation
// Cannot handle cases like ( 1 + 2 + 3 )

package ch1.section3;

import edu.princeton.cs.introcs.StdIn;

public class Evaluate {

  public static double evaluate(String expr) {
    Stack<Double> operands = new Stack<>();
    Stack<String> operators = new Stack<>();

    String[] tokens = expr.split(" ");
    for (String tok : tokens) {
      switch (tok) {
        case "(":
          break;
        case "+":
        case "-":
        case "*":
        case "/":
          operators.push(tok);
          break;
        case ")":
          operands.push(evalSubExpression(operands.pop(), operands.pop(),
              operators.pop()));
          break;
        default:
          operands.push(Double.parseDouble(tok));
      }
    }
    return operands.pop();
  }

  private static double evalSubExpression(Double v1, Double v2, String op) {
    switch (op) {
      case "+":
        return v2 + v1;
      case "-":
        return v2 - v1;
      case "*":
        return v2 * v1;
      case "/":
        if (v1 == 0) {
          throw new RuntimeException("Attempt to divide by 0");
        }
        return v2 / v1;
      default:
        throw new RuntimeException("Unknown operation");
    }
  }
}

class EvaluateDriver {

  /* Test with
   *  ( ( 1 + 2 ) * ( 5 - 6 ) )
   */
  public static void main(String[] args) {
    while (!StdIn.isEmpty()) {
      String s = StdIn.readLine();
      System.out.println(Evaluate.evaluate(s));
    }
  }
}
