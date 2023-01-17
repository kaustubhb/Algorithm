/* Develop a class ResizingArrayQueueOfStrings that implements the queue abstraction
 * with a fixed-size array, and then extend your implementation to use array resizing to remove
 * the size restriction.
 */

package ch1.section3;

import java.util.Iterator;

public class Ex14_ResizingArrayQueue<Item> implements Iterable<Item> {

  private Item[] fStorage;
  private int fCapacity;
  private int fSize;
  private int fFront, fBack;

  public Ex14_ResizingArrayQueue() {
    fStorage = (Item[]) new Object[1];
    fCapacity = 1;
    fSize = 0;
    fFront = -1;
    fBack = 0;
  }

  public boolean isEmpty() {
    return fSize == 0;
  }

  public int size() {
    return fSize;
  }

  private int next(int i) {
    return (i + 1) % fCapacity;
  }

  public void enqueue(Item item) {
    if (fSize >= fCapacity) {
      resize(fCapacity * 2);
    }

    if (fFront == -1) {
      fFront = 0;
      fBack = 0;
    }
    fStorage[fBack] = item;
    fBack = next(fBack);
    ++fSize;
  }

  public Item dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Empty queue");
    }
    Item it = fStorage[fFront];
    fStorage[fFront] = null;
    --fSize;
    if (fSize == 0) {
      fFront = -1;
    } else {
      fFront = next(fFront);
    }

    if (fSize < fCapacity / 4) {
      resize(Math.max((fCapacity + 1) / 2, 1));
    }
    return it;
  }

  private void resize(int cap) {
    Item[] newStorage = (Item[]) new Object[cap];
    int j = fFront;
    for (int i = 0; i < fSize; ++i) {
      newStorage[i] = fStorage[j];
      j = next(j);
    }
    fStorage = newStorage;
    fCapacity = cap;
    fBack = fSize;
    fFront = 0;
  }

  @Override
  public Iterator<Item> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<Item> {

    int j = fFront;
    int count = fSize;

    @Override
    public boolean hasNext() {
      return count > 0;
    }

    @Override
    public Item next() {
			if (!hasNext()) {
				throw new RuntimeException("No more elements to iterate");
			}
      Item it = fStorage[j];
      j = Ex14_ResizingArrayQueue.this.next(j);
      --count;
      return it;
    }
  }
}
