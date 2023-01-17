package ch1.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class Ex14Log2Test {

  @Test
  void testLog2() {
    assertEquals(3, Ex14_Log2.log2(10));
    assertEquals(4, Ex14_Log2.log2(16));
    assertEquals(0, Ex14_Log2.log2(1));
  }

  @Test
  void testLog2Error() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> Ex14_Log2.log2(-1));
    assertEquals("Argument must be positive integer.", ex.getMessage());
  }
}