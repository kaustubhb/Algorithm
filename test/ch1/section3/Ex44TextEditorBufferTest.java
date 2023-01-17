package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex44TextEditorBufferTest {

  @Test
  public void testTextEditorBuffer() {
    Ex44_TextEditorBuffer buffer = new Ex44_TextEditorBuffer();
    for (int c : "abcddef".chars().toArray()) {
      buffer.insert((char) c);
    }
    assertEquals("[f, e, d, d, c, b, a][]", buffer.toString());
    buffer.left(3);
    assertEquals("[d, c, b, a][d, e, f]", buffer.toString());
    buffer.insert('x');
    assertEquals("[x, d, c, b, a][d, e, f]", buffer.toString());
    buffer.right(2);
    assertEquals("[e, d, x, d, c, b, a][f]", buffer.toString());
    buffer.delete();
    assertEquals("[d, x, d, c, b, a][f]", buffer.toString());
    assertEquals(7, buffer.size());
  }
}