package ch1.section2;

import static ch1.section2.Ex6_Rotation.checkRotation;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Ex6_RotationTest {

  @Test
  public void testCheckRotation() {
    assertTrue(checkRotation("abc", "bca"));
    assertFalse(checkRotation("abc", "bac"));
    assertFalse(checkRotation("abc", "ab"));
    assertTrue(checkRotation("", ""));
  }

}