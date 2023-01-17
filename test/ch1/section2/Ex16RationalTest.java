package ch1.section2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Ex16RationalTest {

  @Test
  public void testToString() {
    assertEquals(new Ex16_Rational(10, 20).toString(), "1/2");
    assertEquals(new Ex16_Rational(5, 1).toString(), "5");
    assertEquals(new Ex16_Rational(-5, 10).toString(), "-1/2");
    assertEquals(new Ex16_Rational(5, -10).toString(), "-1/2");
    assertEquals(new Ex16_Rational(0, 1).toString(), "0");
  }

  @Test
  public void testEquals() {
    assertEquals(new Ex16_Rational(10, 5), new Ex16_Rational(2));
    assertEquals(new Ex16_Rational(10, -5), new Ex16_Rational(-2));
    assertEquals(new Ex16_Rational(10, -5), new Ex16_Rational(-20, 10));
  }

  @Test
  public void testPlus() {
    assertEquals(new Ex16_Rational(2, 3).plus(new Ex16_Rational(
        1, 3)), new Ex16_Rational(1));
    assertEquals(new Ex16_Rational(1, 3).plus(new Ex16_Rational(
        2, -6)), new Ex16_Rational(0));
  }

  @Test
  public void testMinus() {
    assertEquals(new Ex16_Rational(2, 3).minus(new Ex16_Rational(
        1, 3)), new Ex16_Rational(1, 3));
    assertEquals(new Ex16_Rational(-11, 2), new Ex16_Rational(-5).minus(new Ex16_Rational(1, 2)));
  }

  @Test
  public void testTimes() {
    assertEquals(new Ex16_Rational(4), new Ex16_Rational(2, 3).times(new Ex16_Rational(6)));
  }

  @Test
  public void divides() {
    assertEquals(new Ex16_Rational(5, 6), new Ex16_Rational(5, 3).divides(new Ex16_Rational(2)));
  }

  @Test
  public void dividesException() {
    Exception ex = assertThrows(ArithmeticException.class, () -> {
      new Ex16_Rational(5, 3).divides(new Ex16_Rational(0));
    });
    assertEquals("Denominator cannot be zero", ex.getMessage());
  }
}