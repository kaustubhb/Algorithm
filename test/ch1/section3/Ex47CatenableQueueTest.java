package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Ex47CatenableQueueTest {

  @Test
  public void testCatenableQueue() {
    Ex47_CatenableQueue<String> cq = new Ex47_CatenableQueue<>();
    List<String> removed = new ArrayList<>();
    for (String t : "just some - random - text and more - - -".split(" ")) {
      if (t.equals("-")) {
        removed.add(cq.dequeue());
      } else {
        cq.enqueue(t);
      }
    }

    assertEquals(cq.size(), 1);
    assertEquals(String.join(" ", removed), "just some random text and");
    assertEquals(cq.dequeue(), "more");
  }

  @Test
  public void testCatenation() {
    Ex47_CatenableQueue<String> q1 = new Ex47_CatenableQueue<>();
    Ex47_CatenableQueue<String> q2 = new Ex47_CatenableQueue<>();
    for (String s : "a b c".split(" ")) {
      q1.enqueue(s);
    }
    for (String s : "d e f".split(" ")) {
      q2.enqueue(s);
    }
    Ex47_CatenableQueue<String> q3 = Ex47_CatenableQueue.catenateQueues(q1, q2);
    assertEquals(6, q3.size());
    List<String> elements = new ArrayList<>();
    for (String s : q3) {
      elements.add(s);
    }
    assertEquals("a b c d e f", String.join(" ", elements));
  }

}