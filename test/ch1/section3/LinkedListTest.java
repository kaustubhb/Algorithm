package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class LinkedListTest {

  @Test
  public void testLinkedList() {
    LinkedList<String> ll = LinkedListHelper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    assertEquals("[times, of, best, the, was, It]", ll.toString());
    assertEquals("times", ll.removeFront());
    assertEquals(5, ll.size());
  }

  @Test void testPushBack() {
    LinkedList<String> ll = new LinkedList<>();
    for(String s: "It was the best of times".split(" ")) {
      ll.pushBack(s);
    }
    assertEquals(6, ll.size());
    assertEquals("[It, was, the, best, of, times]", ll.toString());
  }

  @Test
  public void testIteration() {
    LinkedList<String> ll = LinkedListHelper.buildLinkedList(
        Arrays.asList("It was the best of times".split(" ")));
    List<String> list = new ArrayList<>();
    for (String s : ll) {
      list.add(s);
    }
    Collections.reverse(list);
    assertEquals(Arrays.asList("It was the best of times".split(" ")), list);
  }

}