package ch1.section2;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Ex12SmartDateTest {

  @Test
  public void dayOfWeek() {
    Ex12_SmartDate date = new Ex12_SmartDate(20, 3, 2020);
    assertEquals(date.dayOfWeek(), "Friday");
    assertEquals(new Ex12_SmartDate(29, 12, 2022).dayOfWeek(), "Thursday");
  }

  @Test
  public void testInvalidDate() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Ex12_SmartDate(29, 2, 2022);
    });
    assertEquals("Invalid day", ex.getMessage());
  }
}