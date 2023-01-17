package ch1.section4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Ex18_LocalMinimum {

  public static int localMinimum(int[] arr) {
    if (arr.length == 0) {
      throw new IllegalArgumentException("Array length should be >= 1");
    }
    return localMinimum(arr, 0, arr.length - 1);
  }

  private static int localMinimum(int[] arr, int a, int b) {
    if (a == b) {
      return a;
    }
    int mid = a + (b - a) / 2;
    int left = mid == a ? Integer.MAX_VALUE : arr[mid - 1];
    int right = mid == b ? Integer.MAX_VALUE : arr[mid + 1];
    if (arr[mid] < left && arr[mid] < right) {
      return mid;
    } else if (arr[mid] > left) {
      return localMinimum(arr, a, mid - 1);
    } else {
      return localMinimum(arr, mid + 1, b);
    }
  }
}

class Ex18LocalMinimumTest {

  @Test
  public void testLocalMinimum() {
    assertEquals(0, Ex18_LocalMinimum.localMinimum(new int[]{1, 2, 3, 4}));
    assertEquals(3, Ex18_LocalMinimum.localMinimum(new int[]{4, 3, 2, 1}));
    assertEquals(2, Ex18_LocalMinimum.localMinimum(new int[]{4, 3, 2, 3}));

  }
}
