package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Ex36RandomQueueTest {

  @Test
  public void testRandomQueue() {
    Ex36_RandomQueue<Integer> q = new Ex36_RandomQueue<>();
    for (int i = 1; i <= 10; ++i) {
      q.enqueue(i * i);
    }

    int sum = 0;
    for (int x : q) {
      sum += x;
    }
    assertEquals(sum, 385);
    long x = Math.round(Math.sqrt(q.sample()));
    assertTrue(x >= 1 && x <= 10);

    sum = 0;
    for (int i = 0; i < 10; ++i) {
      sum += q.dequeue();
    }
    assertEquals(sum, 385);
    assertTrue(q.isEmpty());
  }
}