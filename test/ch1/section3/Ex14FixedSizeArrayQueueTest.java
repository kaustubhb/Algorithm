package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Ex14FixedSizeArrayQueueTest {

  @Test
  public void testQueue() {
    Ex14_FixedSizeArrayQueue<String> queue = new Ex14_FixedSizeArrayQueue<>(5);
    queue.enqueue("Mr.");
    queue.enqueue("and");
    queue.enqueue("Mrs.");

    assertEquals(3, queue.size());
    assertEquals("Mr.", queue.dequeue());
    assertEquals("and", queue.dequeue());
    queue.enqueue("Dursley");
    queue.enqueue("of");
    queue.enqueue("number");
    queue.enqueue("four");

    assertTrue(queue.isFull());

    List<String> list = new ArrayList<>();
    for (var s : queue) {
      list.add(s);
    }
    assertEquals("Mrs. Dursley of number four", String.join(" ", list));
  }

}