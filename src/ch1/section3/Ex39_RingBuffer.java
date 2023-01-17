// Ring buffer. A ring buffer, or circular queue, is a FIFO data structure of a fixed
//	size N. It is useful for transferring data between asynchronous processes or for storing
//	log files. When the buffer is empty, the consumer waits until data is deposited; when the
//	buffer is full, the producer waits to deposit data. Develop an API for a RingBuffer and
//	an implementation that uses an array representation (with circular wrap-around).

package ch1.section3;

class Ex39_RingBuffer<Item> {

  private final Item[] store;
  private final int capacity;
  private int front, end;

  public Ex39_RingBuffer(int sz) {
    if (sz <= 0) {
      throw new RuntimeException();
    }
    store = (Item[]) new Object[sz + 1];
    front = 0;
    end = (front + 1) % (sz + 1);
    this.capacity = sz + 1;
  }

  public boolean isEmpty() {
    return (front + 1) % capacity == end;
  }

  public boolean isFull() {
    return front == end;
  }

  public void deposit(Item it) {
    if (!isFull()) {
      store[end] = it;
      end = (end + 1) % capacity;
    } else {
      throw new RuntimeException();
    }
  }

  public Item remove() {
    if (!isEmpty()) {
      Item it = store[front];
      store[front] = null;
      front = (front + 1) % capacity;
      return it;
    } else {
      throw new RuntimeException();
    }
  }

  public int size() {
    return (end - 1 - front + capacity) % capacity;
  }
}