/* Random iterator. Write an iterator for RandomQueue<Item> from the previous
 * exercise that returns the items in random order.
 */

package ch1.section3;

import edu.princeton.cs.introcs.StdRandom;
import java.util.Iterator;
import utils.MyUtils;

public class Ex36_RandomQueue<T> implements Iterable<T> {

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

  @Override
  public Iterator<T> iterator() {
    return new RandomQueueIterator();
  }

  private class RandomQueueIterator implements Iterator<T> {

    Integer[] order;
    int index;

    public RandomQueueIterator() {
      order = new Integer[size];
      for (int i = 0; i < order.length; ++i) {
        order[i] = i;
      }
      MyUtils.shuffle(order);
      index = 0;
    }

    @Override
    public boolean hasNext() {
      return index < order.length;
    }

    @Override
    public T next() {
      return storage[order[index++]];
    }
  }
}







