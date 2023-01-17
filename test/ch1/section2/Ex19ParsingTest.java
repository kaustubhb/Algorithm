package ch1.section2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Ex19ParsingTest {

  @Test
  void dateFromString() {
    assertEquals("10/12/2001", Ex19_Parsing.dateFromString("10/12/2001").toString());
  }

  @Test
  void transactionFromString() {
    assertEquals("Turing 22/5/1939 11.99",
        Ex19_Parsing.transactionFromString("Turing 22/5/1939 11.99").toString());
  }
}