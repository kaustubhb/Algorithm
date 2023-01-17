// Copy a queue. Create a new constructor so that
// Queue<Item> r = new Queue<Item>(q);
// makes r a reference to a new and independent copy of the queue q. You should be able
// to push and pop from either q or r without influencing the other.

package ch1.section3;

import java.util.ArrayList;
import java.util.List;

public class Ex41_CopyQueue {

  public static <T> Queue copyQueue(Queue<T> q) {
    Queue<T> newQueue = new Queue<>();
    List<T> temp = new ArrayList<>();
    while (!q.isEmpty()) {
      temp.add(q.dequeue());
    }
    for (T t : temp) {
      newQueue.enqueue(t);
      q.enqueue(t);
    }
    return newQueue;
  }
}
