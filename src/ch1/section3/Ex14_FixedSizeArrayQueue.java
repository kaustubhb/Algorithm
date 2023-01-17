/* Develop a class ResizingArrayQueueOfStrings that implements the queue abstraction
 * with a fixed-size array, and then extend your implementation to use array resizing to remove
 * the size restriction.
 */

package ch1.section3;

import java.util.Iterator;

public class Ex14_FixedSizeArrayQueue<Item> implements Iterable<Item> {

  private final Item[] fItems;
  private int fFront;
  private int fSize;

  public Ex14_FixedSizeArrayQueue(int size) {
    fItems = (Item[]) new Object[size];
    fFront = 0;
    fSize = 0;
  }

  public boolean isFull() {
    return fSize == fItems.length;
  }

  public boolean isEmpty() {
    return fSize == 0;
  }

  public int size() {
    return fSize;
  }

  public void enqueue(Item item) {
    if (isFull()) {
      throw new RuntimeException("Queue full, can't add more items.");
    }
    fItems[nextIndex(getBack())] = item;
    ++fSize;
  }

  public Item dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue empty, can't remove anything.");
    }
    Item temp = fItems[fFront];
    fItems[fFront] = null;
    fFront = nextIndex(fFront);
    --fSize;
    return temp;
  }

  private int nextIndex(int index) {
    return (index + 1) % fItems.length;
  }

  private int getBack() {
    return (fFront + fSize - 1) % fItems.length;
  }

  @Override
  public Iterator<Item> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<Item> {

    private int fCount;

    public QueueIterator() {
      fCount = 0;
    }

    @Override
    public boolean hasNext() {
      return fCount < fSize;
    }

    @Override
    public Item next() {
      return fItems[(fFront + fCount++) % fItems.length];
    }
  }
}
