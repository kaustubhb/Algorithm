package ch1.section4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Ex8EqualPairsTest {

  @Test
  void testCountEqualPairs() {
    assertEquals(4, Ex8_EqualPairs.countEqualPairs(new ArrayList<>(Arrays.asList(1, 2, 1, 1, 2))));
    assertEquals(7, Ex8_EqualPairs.countEqualPairs(new ArrayList<>(Arrays.asList(1, 2, 1, 1, 2, 3, 3, 3))));
  }
}