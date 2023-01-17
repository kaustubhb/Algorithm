package utils;

import edu.princeton.cs.introcs.StdRandom;

public class MyUtils {

  public static int[] generateRandomArray(int numElements, int range) {
    int[] result = new int[numElements];
    for (int i = 0; i < numElements; ++i) {
      result[i] = StdRandom.uniform(range);
    }
    return result;
  }

  public static long gcd(long a, long b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static <T> void shuffle(T[] arr) {
    for (int i = 0; i < arr.length - 1; ++i) {
      int pos = StdRandom.uniform(i, arr.length);
      T temp = arr[pos];
      arr[pos] = arr[i];
      arr[i] = temp;
    }
  }
}
