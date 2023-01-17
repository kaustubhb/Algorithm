package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex41CopyQueueTest {

  @Test
  void copyQueue() {
    Queue<String> q = new Queue<>();
    for (String s : "Whatever you are be a good one".split(" ")) {
      q.enqueue(s);
    }
    assertEquals("[Whatever, you, are, be, a, good, one]", q.toString());
    assertEquals(q.toString(), Ex41_CopyQueue.copyQueue(q).toString());

  }
}