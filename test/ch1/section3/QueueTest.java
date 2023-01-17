package ch1.section3;

import static org.junit.jupiter.api.Assertions.*;

import edu.princeton.cs.introcs.In;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class QueueTest {
  @Test
  public void testQueue() {
    Queue<String> q = new Queue<>();
    In in = new In("files/tobe.txt");
    while (!in.isEmpty()) {
      String s = in.readString();
      if (!s.equals("-")) {
        q.enqueue(s);
      } else {
        q.dequeue();
      }
    }
    assertEquals(q.size(), 2);

    var it = q.iterator();
    assertTrue(it.hasNext() && it.next().equals("that"));
    assertEquals("is", it.next());
    assertFalse(it.hasNext());
  }

  @Test
  public void testIteration() {
    Queue<String> fs = new Queue<>();
    String[] input = "it was the best of times".split(" ");
    for (var s : input) {
      fs.enqueue(s);
    }
    List<String> ls = new ArrayList<>();
    for (var s : fs) {
      ls.add(s);
    }
    assertArrayEquals("it was the best of times".split(" "), ls.toArray());
  }
}