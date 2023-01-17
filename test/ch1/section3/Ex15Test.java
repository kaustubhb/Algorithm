package ch1.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Ex15Test {

  private Queue<String> buildQueue(String line) {
    Queue<String> q = new Queue<>();
    for (String w : line.split(" ")) {
      q.enqueue(w);
    }
    return q;
  }

  @Test
  public void testGetKthElement() {
    Assertions.assertEquals("perfectly", Ex15.getKthElement(
        buildQueue("Mr. and Mrs. Dursley of number four privet drive were perfectly normal people"),
        3));
  }

}