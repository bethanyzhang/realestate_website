package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResidentialTest {
  Residential testResidential;

  @BeforeEach
  void setUp() throws InvalidInputException {
    testResidential = new Residential("Address", 1,1,1.0);
  }

  @Test
  void testSize() {
    Integer expectedSize = 1;
    assertEquals(expectedSize, testResidential.getSize());
  }

  @Test
  void testRentalWithInvalidInputBedroom() {
    assertThrows(InvalidInputException.class, () -> new Residential("Address",1,
        -1,1.0));
  }

  @Test
  void testRentalWithInvalidInputBathroom() {
    assertThrows(InvalidInputException.class, () -> new Residential("Address",1,
        1,-1.0));
  }

  @Test
  void testRentalWithInvalidInputSize() {
    assertThrows(InvalidInputException.class, () -> new Residential("Address",-1,
        1,1.0));
  }

  @Test
  void getNumOfBedrooms() {
    Integer expectedNum = 1;
    assertEquals(expectedNum, testResidential.getNumOfBedrooms());
  }

  @Test
  void getNumOfBathrooms() {
    Double expectedNum = 1.0;
    assertEquals(expectedNum, testResidential.getNumOfBathrooms());
  }

  @Test
  void getSize() {
    Integer expectedSize = 1;
    assertEquals(expectedSize, testResidential.size);
  }
  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testResidential.equals(testResidential));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testResidential.equals(null));
  }

  @Test
  void testEquals_SameFieldOverall() throws InvalidInputException {
    Residential newTestResidential = new Residential("Address", 1,1,1.0);
    assertTrue(testResidential.equals(newTestResidential));
  }
  @Test
  void testEquals_DifferentDataTypes() throws InvalidInputException {
    Sale testSale = new Sale(1.0,true);
    assertFalse(testResidential.equals(testSale));
  }

  @Test
  void testEquals_DifferentObject() throws InvalidInputException {
    Residential newTestResidential = new Residential("Different Address", 2,
        2,2.0);
    assertFalse(testResidential.equals(newTestResidential));
  }

  @Test
  void testEqual_DifferentNumOfBedrooms() throws InvalidInputException {
    Residential newTestResidential = new Residential("Address", 1,2,1.0);
    assertFalse(testResidential.equals(newTestResidential));
  }

  @Test
  void testEqual_DifferentNumOfBathrooms() throws InvalidInputException {
    Residential newTestResidential = new Residential("Address", 1,1,2.0);
    assertFalse(testResidential.equals(newTestResidential));
  }

  @Test
  void testHashCode() {
    int expectedHash = testResidential.hashCode();
    assertEquals(expectedHash, testResidential.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Residential{" +
        "numOfBedrooms=" + testResidential.getNumOfBedrooms() +
        ", numOfBathrooms=" + testResidential.getNumOfBathrooms() +
        ", address='" + testResidential.getAddress() + '\'' +
        ", size=" + testResidential.getSize() +
        '}';
    assertEquals(expectedString, testResidential.toString());
  }
}