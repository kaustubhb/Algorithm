// Write a Queue client that takes a command-line argument k and prints the kth
// from the last string found on standard input (assuming that standard input has k or
// more strings).

package ch1.section3;

public class Ex15 {

  public static <Item> Item getKthElement(Queue<Item> queue, int k) {
    if (k > queue.size()) {
      throw new RuntimeException("k should be <= queue size");
    }
    int size = queue.size();
    for (int i = 0; i < size - k; ++i) {
      queue.dequeue();
    }
    return queue.dequeue();
  }
}
