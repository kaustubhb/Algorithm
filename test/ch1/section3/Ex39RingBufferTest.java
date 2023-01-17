package ch1.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Ex39RingBufferTest {

  private final int SZ = 10;
  private final int INIT = 4;
  private Ex39_RingBuffer<Integer> rb;

  @BeforeEach
  public void setUp() {
    rb = new Ex39_RingBuffer<>(SZ);
    for (int i = 0; i < INIT; ++i) {
      rb.deposit(i);
    }
  }

  @AfterEach
  public void tearDown() {
    rb = null;
  }

  @Test
  public void testIsEmpty() {
    for (int i = 0; i < INIT; ++i) {
      rb.remove();
    }

    assertTrue(rb.isEmpty());
  }

  @Test
  public void testIsFull() {
    for (int i = 0; i < SZ - INIT; ++i) {
      rb.deposit(i);
    }
    assertTrue(rb.isFull());
  }

  @Test
  public void testDepositAndRemove() {
    for (int i = 0; i < SZ - INIT; ++i) {
      rb.deposit(i + 10);
    }
    assertEquals(rb.size(), SZ);
    for (int i = 0; i < 5; ++i) {
      rb.remove();
    }
    assertEquals(rb.size(), SZ - 5);

    for (int i = 0; i < 5; ++i) {
      rb.deposit(i + 100);
    }
    assertEquals(rb.size(), SZ);
  }

}
