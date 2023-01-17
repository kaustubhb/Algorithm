package ch1.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex11Print2DBooleanArrayTest {

  @Test
  void testGenerateString() {
    boolean[][] arr = {{true, false},
        {false, true}};
    String expected = "*   \n  * ";
    assertEquals(expected, Ex11_Print2DBooleanArray.generateString(arr));
    assertEquals("", Ex11_Print2DBooleanArray.generateString(new boolean[0][]));
  }
}