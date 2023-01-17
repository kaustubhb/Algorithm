// Write a class RandomBag that implements Bag's API. Note that this API is the same as for
//	Bag, except for the adjective random, which indicates that the iteration should provide
// 	the items in random order (all N ! permutations equally likely, for each iterator).
// 	Hint: Put the items in an array and randomize their order in the iterator’s constructor.

package ch1.section3;

import java.util.ArrayList;
import java.util.Iterator;
import utils.MyUtils;

public class Ex34_RandomBag<T> implements Iterable<T> {

  private final ArrayList<T> storage = new ArrayList<>();

  public boolean isEmpty() {
    return storage.size() == 0;
  }

  public int size() {
    return storage.size();
  }

  public void add(T t) {
    storage.add(t);
  }

  @Override
  public Iterator<T> iterator() {
    return new RandomIterator();
  }

  private class RandomIterator implements Iterator<T> {

    private final Integer[] sequence;
    private int index = 0;

    public RandomIterator() {
      sequence = new Integer[size()];
      for (int i = 0; i < size(); ++i) {
        sequence[i] = i;
      }
      MyUtils.shuffle(sequence);
    }

    @Override
    public boolean hasNext() {
      return index < size();
    }

    @Override
    public T next() {
      return storage.get(sequence[index++]);
    }
  }
}
