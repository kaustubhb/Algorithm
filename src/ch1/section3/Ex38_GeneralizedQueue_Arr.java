/* 1.3.38 Delete kth element. Implement a class that supports the given API.
 * First, develop an implementation that uses an array implementation,
 * and then develop one that uses a linked-list implementation.
 */

package ch1.section3;

public class Ex38_GeneralizedQueue_Arr<Item> {

  private Item[] storage;
  private int size;

  public Ex38_GeneralizedQueue_Arr() {
    storage = (Item[]) new Object[1];
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(Item x) {
    if (size == storage.length) {
      resize(size * 2);
    }
    storage[size++] = x;
  }

  private void resize(int newSize) {
    Item[] newStorage = (Item[]) new Object[newSize];
    System.arraycopy(storage, 0, newStorage, 0, size);
    storage = newStorage;
  }

  public Item delete(int k) {
    if (k >= size) {
      throw new RuntimeException("Invalid index for deletion");
    }
    Item temp = storage[k];
    ++k;
    while (k < size) {
      storage[k - 1] = storage[k];
      ++k;
    }
    --size;
    if (size <= storage.length / 4) {
      resize(storage.length / 2);
    }
    return temp;
  }

  public int size() {
    return size;
  }
}
