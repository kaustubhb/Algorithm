// Text editor buffer. Develop a data type for a buffer in a text editor

package ch1.section3;

public class Ex44_TextEditorBuffer {

  Stack<Character> left;
  Stack<Character> right;

  public Ex44_TextEditorBuffer() {
    left = new Stack<>();
    right = new Stack<>();
  }

  public void insert(Character c) {
    left.push(c);
  }

  public char delete() {
    return left.pop();
  }

  public void left(int k) {
    for (int i = 0; i < k && left.size() > 0; ++i) {
      right.push(left.pop());
    }
  }

  public void right(int k) {
    for (int i = 0; i < k && right.size() > 0; ++i) {
      left.push(right.pop());
    }
  }

  public int size() {
    return left.size() + right.size();
  }

  @Override
  public String toString() {
    return left.toString() + right.toString();
  }
}
