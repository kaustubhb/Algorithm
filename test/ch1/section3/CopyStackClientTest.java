package ch1.section3;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CopyStackClientTest {

  @Test
  public void testCopyStack() {
    Stack<String> stack = new Stack<>();
    String[] tokens = "Just some random text".split(" ");
    for (String s : tokens) {
      stack.push(s);
    }
    List<String> origList = new ArrayList<>();
    for (String s : stack) {
      origList.add(s);
    }
    List<String> copyList = new ArrayList<>();
    for (String s : Ex12_CopyStackClient.copy(stack)) {
      copyList.add(s);
    }
    Assertions.assertEquals(origList, copyList);
  }
}