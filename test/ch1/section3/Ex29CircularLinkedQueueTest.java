package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Ex29CircularLinkedQueueTest {

  @Test
  public void testCircularLinkedQueue() {
    Ex29_CircularLinkedQueue<String> cq = new Ex29_CircularLinkedQueue<>();
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
}
