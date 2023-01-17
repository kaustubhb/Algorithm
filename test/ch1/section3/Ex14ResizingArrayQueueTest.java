package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.princeton.cs.introcs.In;
import org.junit.jupiter.api.Test;


public class Ex14ResizingArrayQueueTest {

  @Test
  public void testQueue() {
    Ex14_ResizingArrayQueue<String> q = new Ex14_ResizingArrayQueue<>();
    In in = new In("files/tobe.txt");
    while (!in.isEmpty()) {
      String s = in.readString();
      if (!s.equals("-")) {
        q.enqueue(s);
      } else {
        s = q.dequeue();
      }
    }
    assertEquals(q.size(), 2);

    var it = q.iterator();
    assertTrue(it.hasNext() && it.next().equals("that"));
    assertEquals("is", it.next());
    assertFalse(it.hasNext());
  }
}