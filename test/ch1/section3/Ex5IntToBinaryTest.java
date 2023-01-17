package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Ex5IntToBinaryTest {

  @Test
  public void testGetBinary() {
    var obj = new Ex5_IntToBinary();
    assertEquals("101", obj.getBinary(5));
    assertEquals("0", obj.getBinary(0));
  }
}