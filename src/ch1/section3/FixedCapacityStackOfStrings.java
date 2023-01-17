package ch1.section3;

public class FixedCapacityStackOfStrings {
  private final String[] fItems;
  private int fSize;

  public FixedCapacityStackOfStrings(int capacity) {
    fItems = new String[capacity];
    fSize = 0;
  }

  public void push(String item) {
    if (!isFull()) {
      fItems[fSize++] = item;
    } else {
      throw new RuntimeException("Stack is full.");
    }
  }

  public boolean isFull() {
    return fSize == fItems.length;
  }

  public String pop() {
    if (fSize == 0) {
      throw new RuntimeException("Stack is empty.");
    }
    String ret = fItems[--fSize];
    fItems[fSize] = null;
    return ret;
  }

  public int size() {
    return fSize;
  }
}
