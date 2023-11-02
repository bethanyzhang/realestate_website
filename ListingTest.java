package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListingTest {
  private Listing<Residential,Sale> testListing;

  @BeforeEach
  void setUp() throws InvalidInputException {
    Residential testResidential = new Residential("Address",1,1,1.0);
    Sale testSale = new Sale(100.0,true);
    testListing = new Listing<>(testResidential,testSale);
  }

  @Test
  void getProperty() throws InvalidInputException {
    Residential testResidential = new Residential("Address",1,1,1.0);
    assertEquals(testListing.getProperty(), testResidential);
  }

  @Test
  void getContract() throws InvalidInputException {
    Sale expectedSale = new Sale(100.0,true);
    assertEquals(testListing.getContract(), expectedSale);
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testListing.equals(testListing));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testListing.equals(null));
  }

  @Test
  void testEquals_SameFieldOverall() throws InvalidInputException {
    Residential newTestResidential = new Residential("Address",1,1,1.0);
    Sale newTestSale = new Sale(100.0,true);
    Listing newTestListing = new Listing<>(newTestResidential, newTestSale);
    assertTrue(testListing.equals(newTestListing));
  }
  @Test
  void testEquals_DifferentDataTypes() throws InvalidInputException {
    Sale testSale = new Sale(1.0,true);
    assertFalse(testListing.equals(testSale));
  }

  @Test
  void testEquals_DifferentObject() throws InvalidInputException {
    Residential newTestResidential = new Residential("Address",2,2,2.0);
    Sale newTestSale = new Sale(200.0,false);
    Listing newTestListing = new Listing<>(newTestResidential, newTestSale);
    assertFalse(testListing.equals(newTestListing));
  }

  @Test
  void testEqual_DifferentProperty() throws InvalidInputException {
    Commercial testCommercial = new Commercial("Address",2,2,true);
    Sale testSale = new Sale(100.0,true);
    Listing newTestListing = new Listing<>(testCommercial,testSale);
    assertFalse(testListing.equals(newTestListing));
  }

  @Test
  void testEqual_DifferentContract() throws InvalidInputException {
    Residential testResidential = new Residential("Address",1,1,1.0);
    Rental testRental = new Rental(1.0,true,12);
    Listing newTestListing = new Listing<>(testResidential,testRental);
    assertFalse(testListing.equals(newTestListing));
  }

  @Test
  void testHashCode() {
    int expectedHash = testListing.hashCode();
    assertEquals(expectedHash, testListing.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Listing{" +
        "property=" + testListing.getProperty() +
        ", contract=" + testListing.getContract() +
        '}';
    assertEquals(expectedString, testListing.toString());
  }
}