package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommercialTest {
  Commercial testCommercial;


  @BeforeEach
  void setUp() throws InvalidInputException {
    testCommercial = new Commercial("Address",1,1,true);
  }

  @Test
  void testCommercialWithInvalidInput() {
    assertThrows(InvalidInputException.class, () -> new Commercial("Address", 1,
        -1,true));
  }

  @Test
  void getNumOfOffices() {
    Integer expectedNum = 1;
    assertEquals(expectedNum, testCommercial.getNumOfOffices());
  }

  @Test
  void getSize() {
    Integer expectedSize = 1;
    assertEquals(expectedSize, testCommercial.getSize());
  }

  @Test
  void getRetailSuitable() {
    assertTrue(testCommercial.getRetailSuitable());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testCommercial.equals(testCommercial));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testCommercial.equals(null));
  }

  @Test
  void testEquals_SameFieldOverall() throws InvalidInputException {
    Commercial newTestCommercial = new Commercial("Address",1,1,true);
    assertTrue(testCommercial.equals(newTestCommercial));
  }
  @Test
  void testEquals_DifferentDataTypes() throws InvalidInputException {
    Sale testSale = new Sale(1.0,true);
    assertFalse(testCommercial.equals(testSale));
  }

  @Test
  void testEquals_DifferentObject() throws InvalidInputException {
    Commercial newTestCommercial = new Commercial("Different Address",2,3,false);
    assertFalse(testCommercial.equals(newTestCommercial));
  }

  @Test
  void testEqual_DifferentNumOfOffice() throws InvalidInputException {
    Commercial newTestCommercial = new Commercial("Address",1,2,true);
    assertFalse(testCommercial.equals(newTestCommercial));
  }

  @Test
  void testEqual_DifferentSuitable() throws InvalidInputException {
    Commercial newTestCommercial = new Commercial("Address",1,1,false);
    assertFalse(testCommercial.equals(newTestCommercial));
  }

  @Test
  void testHashCode() {
    int expectedHash = testCommercial.hashCode();
    assertEquals(expectedHash, testCommercial.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Commercial{" +
      "numOfOffices=" + testCommercial.getNumOfOffices() +
          ", isRetailSuitable=" + testCommercial.getRetailSuitable() +
          '}';
    assertEquals(expectedString, testCommercial.toString());
  }
}