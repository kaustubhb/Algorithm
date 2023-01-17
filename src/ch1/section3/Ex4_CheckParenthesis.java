/* Write a stack client Parentheses that reads in a text stream from standard input
 * and uses a stack to determine whether its parentheses are properly balanced. For example,
 * your program should print true for [()]{}{[()()]()} and false for [(]) .
 */

package ch1.section3;

public class Ex4_CheckParenthesis {

  public boolean isBalanced(String parenStr) {
    if (parenStr.isEmpty()) {
      return true;
    }
    parenStr = removeSpaces(parenStr);
    Stack<Character> stack = new Stack<>();
    for (char ch : parenStr.toCharArray()) {
      switch (ch) {
        case '(':
        case '[':
        case '{':
          stack.push(ch);
          break;
        case ')':
        case ']':
        case '}':
          char popped = stack.pop();
          if (ch == ')' && popped != '(' || ch == ']' && popped != '['
              || ch == '}' && popped != '{') {
            return false;
          }
          break;
        default:
          throw new RuntimeException("Unknown character in input string");
      }
    }
    return stack.isEmpty();
  }

  private String removeSpaces(String parenStr) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < parenStr.length(); ++i) {
      if (!Character.isSpaceChar(parenStr.charAt(i))) {
        sb.append(parenStr.charAt(i));
      }
    }
    return sb.toString();
  }
}
