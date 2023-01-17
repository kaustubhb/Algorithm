package ch1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
  private Item[] fStack;
  private int top;

  private void resize(int newLen) {
    Item[] temp = (Item[]) new Object[newLen];
    if (top >= 0)
      System.arraycopy(fStack, 0, temp, 0, top);
    fStack = temp;
  }

  public ResizingArrayStack() {
    fStack = (Item[]) new Object[1];
    top = 0;
  }

  public boolean isEmpty() {
    return top == 0;
  }

  public int size() {
    return top;
  }

  public void push(Item item) {
    if (top == fStack.length) {
      resize(fStack.length * 2);
    }
    fStack[top++] = item;
  }

  public Item pop() {
    if (isEmpty()) {
      throw new RuntimeException("Trying to pop from an empty stack");
    }
    Item temp = fStack[--top];
    fStack[top] = null;
    if (top != 0 && top <= fStack.length / 4)
      resize(fStack.length / 2);
    return temp;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {

    private int i = top;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public Item next() {
      if (i == 0) throw new NoSuchElementException();
      return fStack[--i];
    }
  }
}
