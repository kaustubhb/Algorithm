package ch1.section1;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Ex28RemoveDuplicatesTest {

  @Test
  void removeDuplicatesNewList() {
    Assertions.assertArrayEquals(new int[]{1, 2, 3},
        Ex28_RemoveDuplicates.removeDuplicatesNewList(new int[]{1, 2, 3}));
    Assertions.assertArrayEquals(new int[]{1, 2, 3},
        Ex28_RemoveDuplicates.removeDuplicatesNewList(new int[]{1, 1, 2, 3, 3}));
    Assertions.assertArrayEquals(new int[]{},
        Ex28_RemoveDuplicates.removeDuplicatesNewList(new int[]{}));
  }

  @Test
  void removeDuplicatesInPlace() {
    Assertions.assertEquals(Arrays.asList(1,2,3),
        Ex28_RemoveDuplicates.removeDuplicatesInPlace(new ArrayList<>(Arrays.asList(1,2,3))));
    Assertions.assertEquals(Arrays.asList(1,2,3),
        Ex28_RemoveDuplicates.removeDuplicatesInPlace(new ArrayList<>(Arrays.asList(1,1,2,3,3))));
    Assertions.assertEquals(Arrays.asList(),
        Ex28_RemoveDuplicates.removeDuplicatesInPlace(new ArrayList<>(Arrays.asList())));
  }
}