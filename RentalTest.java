package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalTest {
  Rental testRental;

  @BeforeEach
  void setUp() throws InvalidInputException {
    testRental = new Rental(100.0,true,12);
  }

  @Test
  void testRentalWithInvalidInput() throws InvalidInputException {
    assertThrows(InvalidInputException.class, () -> new Rental(100.0,true,-1));
  }

  @Test
  void testSaleWithInvalidInputPrice() {
    assertThrows(InvalidInputException.class, () -> new Rental(-100.0,true,1));
  }

  @Test
  void getTerm() {
    Integer expectedTerm = 12;
    assertEquals(expectedTerm, testRental.getTerm());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testRental.equals(testRental));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testRental.equals(null));
  }

  @Test
  void testEquals_SameFieldOverall() throws InvalidInputException {
    Rental newTestRental = new Rental(100.0,true,12);
    assertTrue(testRental.equals(newTestRental));
  }
  @Test
  void testEquals_DifferentDataTypes() throws InvalidInputException {
    Sale testSale = new Sale(1.0,true);
    assertFalse(testRental.equals(testSale));
  }

  @Test
  void testEquals_DifferentObject() throws InvalidInputException {
    Rental newTestRental = new Rental(200.0,false,10);
    assertFalse(testRental.equals(newTestRental));
  }

  @Test
  void testEqual_DifferentTerm() throws InvalidInputException {
    Rental newTestRental = new Rental(100.0,true,10);
    assertFalse(testRental.equals(newTestRental));
  }

  @Test
  void testEqual_DifferentNegotiable() throws InvalidInputException {
    Rental newTestRental = new Rental(100.0,false,12);
    assertFalse(testRental.equals(newTestRental));
  }


  @Test
  void testHashCode() {
    int expectedHash = testRental.hashCode();
    assertEquals(expectedHash, testRental.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Rental{" +
        "term=" + testRental.getTerm() +
        ", askingPrice=" + testRental.getAskingPrice() +
        ", isNegotiable=" + testRental.getNegotiable() +
        '}';
    assertEquals(expectedString, testRental.toString());
  }
}