package ch1.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Ex9BinaryStringTest {

  @Test
  void testBinaryString() {
    assertEquals("1011", Ex9_BinaryString.binaryString(11));
    assertEquals("0", Ex9_BinaryString.binaryString(0));
    assertEquals("10000", Ex9_BinaryString.binaryString(16));
  }
}
