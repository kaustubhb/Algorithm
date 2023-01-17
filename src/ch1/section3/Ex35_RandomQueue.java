/* Write a class RandomQueue that implements the queue. Hint : Use an array representation
 * (with resizing). To remove an item, swap one at a random position (indexed 0 through
 * N-1) with the one at the last position (index N-1). Then delete and return the last object,
 * as in ResizingArrayStack. Write a client that deals bridge hands (13 cards each)
 * using RandomQueue<Card>
 */

package ch1.section3;

import edu.princeton.cs.introcs.StdRandom;

public class Ex35_RandomQueue<T> {

  private T[] storage = (T[]) new Object[1];
  // private int capacity;
  private int size = 0;

  private void resize(int newLen) {
    T[] temp = (T[]) new Object[newLen];
    for (int i = 0; i < size; ++i) {
      temp[i] = storage[i];
    }
    storage = temp;
  }

  private void swap(int i, int j) {
    T temp = storage[i];
    storage[i] = storage[j];
    storage[j] = temp;
  }

  public void enqueue(T item) {
    if (size == storage.length) {
      resize(2 * size);
    }
    storage[size++] = item;
  }

  public T dequeue() {
    int index = StdRandom.uniform(size);
    swap(index, size - 1);
    T item = storage[size - 1];
    storage[--size] = null;
    return item;
  }

  public T sample() {
    return storage[StdRandom.uniform(size)];
  }

  public boolean isEmpty() {
    return size == 0;
  }
}







