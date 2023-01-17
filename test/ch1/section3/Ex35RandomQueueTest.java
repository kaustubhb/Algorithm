package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Ex35RandomQueueTest {

  @Test
  public void testRandomQueue() {
    Ex35_RandomQueue<Integer> q = new Ex35_RandomQueue<>();
    for (int i = 1; i <= 10; ++i) {
      q.enqueue(i * i);
    }

    long x = Math.round(Math.sqrt(q.sample()));
    assertTrue(x >= 1 && x <= 10);

    int sum = 0;
    for (int i = 0; i < 10; ++i) {
      sum += q.dequeue();
    }
    assertEquals(sum, 385);
    assertTrue(q.isEmpty());
  }
}