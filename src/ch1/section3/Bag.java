// Generic data structure to store and iterate over elements
package ch1.section3;

import edu.princeton.cs.introcs.In;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

  private Node head;
  private int sz = 0;

  public int size() {
    return sz;
  }

  public void add(Item it) {
    Node temp = new Node();
    temp.item = it;
    temp.next = head;
    head = temp;
    ++sz;
  }

  @Override
  public Iterator<Item> iterator() {
    return new BagIterator();
  }

  private class Node {

    Item item;
    Node next;
  }

  private class BagIterator implements Iterator<Item> {

    private Node it = head;

    @Override
    public boolean hasNext() {
      return it != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new RuntimeException("No more elements.");
      }
      Item item = it.item;
      it = it.next;
      return item;
    }
  }
}

class BagClient {

  public static void main(String[] args) {
    Bag<Integer> numbers = new Bag<>();
    In fin = new In("files/tinyT.txt");
    int[] fileNumbers = fin.readAllInts();
    for (int x : fileNumbers) {
      numbers.add(x);
    }
    // Now read from Bag
    assert fileNumbers.length == numbers.size();

    long sum = 0;
    long s = 0;
    for (int x : numbers) {
      sum += x;
    }
    double mean = 1.0 * sum / numbers.size();
    for (int x : numbers) {
      s += (x - mean) * (x - mean);
    }
    double stddev = Math.sqrt(1.0 * s / (numbers.size() - 1));
    System.out.printf("Mean = %f, Standard Deviation = %f\n", mean, stddev);
  }
}
