// Binary representation of argument

package ch1.section3;
public class Ex5_IntToBinary {

  public String getBinary(int n) {
    Stack<Integer> stack = new Stack<>();
    while (n > 0) {
      stack.push(n % 2);
      n /= 2;
    }
    if (stack.isEmpty()) {
      stack.push(0);
    }
    StringBuilder sb = new StringBuilder();
    for (int i : stack) {
      sb.append(i);
    }
    return sb.toString();
  }
}
