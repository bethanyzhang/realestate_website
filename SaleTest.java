package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SaleTest {
  Sale testSale;

  @BeforeEach
  void setUp() throws InvalidInputException {
    testSale = new Sale(1.0,true);
  }

  @Test
  void testSaleWithInvalidInputPrice() {
    assertThrows(InvalidInputException.class, () -> new Sale(-1.0,true));
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testSale.equals(testSale));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testSale.equals(null));
  }

  @Test
  void testEquals_SameFieldOverall() throws InvalidInputException {
    Sale newTestSale = new Sale(1.0,true);
    assertTrue(testSale.equals(newTestSale));
  }
  @Test
  void testEquals_DifferentDataTypes() throws InvalidInputException {
    Commercial testCommercial = new Commercial("Address",1,1,true);
    assertFalse(testSale.equals(testCommercial));
  }

  @Test
  void testEquals_DifferentObject() throws InvalidInputException {
    Sale newTestSale = new Sale(200.0,false);
    assertFalse(testSale.equals(newTestSale));
  }

  @Test
  void testToString() {
    String expectedString = "Sale{" +
        "askingPrice=" + testSale.askingPrice +
        ", isNegotiable=" + testSale.getNegotiable() +
        '}';
    assertEquals(expectedString, testSale.toString());
  }
}