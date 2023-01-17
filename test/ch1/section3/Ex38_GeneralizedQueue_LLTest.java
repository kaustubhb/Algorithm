package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex38GeneralizedQueueLLTest {

  @Test
  public void testQueue() {
    Ex38_GeneralizedQueue_LL<String> q = new Ex38_GeneralizedQueue_LL<>();
    for (String s : "Whatever you are be a good one".split(" ")) {
      q.insert(s);
    }
    assertEquals("Whatever", q.delete(0));
    assertEquals("a", q.delete(3));
    assertEquals(5, q.size());
  }

}