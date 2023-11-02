package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AgentTest {
  Commercial testCommercial = new Commercial("123",12,10,true);
  Residential testResidential = new Residential("10",3,3,2.5);
  Sale testSale = new Sale(11.1,true);
  Rental testRental = new Rental(100.1,false,1);
  AgentTest() throws InvalidInputException {
  }
  @Test
  public void testConstructor() throws InvalidInputException{
    String expectedMessage = "Commission rate must be between 0 and 1";
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
      Agent<Commercial, Sale> agent = new Agent<>("test", new ArrayList<>(), 3.0, 0.0);
    });
    String actualMessage = exception.getMessage();
    assertEquals(expectedMessage, actualMessage);
    Agent<String,Integer>agent = new Agent<>("test",new ArrayList<>(),0.2,0.0);

  }
  public void testAddListing() throws InvalidInputException {
    // Create an Agent object
    Agent<Commercial, Sale> agent = new Agent<>("test", new ArrayList<>(), 0.5, 0.0);

    // Create a Listing object
    Listing listing = new Listing(testCommercial, testRental);

    // Add the listing to the agent's list
    agent.addListing(listing);

    // Assert that the listing was added successfully
    assertEquals(1, agent.getListings().size());
    assertEquals(listing, agent.getListings().get(0));
  }

  @Test
  public void testCompleteListing() throws ListingNotFoundException, InvalidInputException {
    // Create an Agent object
    Agent<Residential, Rental> agent = new Agent<>("oh mine", new ArrayList<>(), 0.5, 0.0);

    // Create a Listing object
    Listing listing = new Listing(testResidential, testRental);
    Listing listing2 = new Listing(testCommercial, testRental);

    // Add the listing to the agent's list
    agent.addListing(listing);

    // Complete the listing
    agent.completeListing(listing);
    String expectedMessage = "The listing is not on the agent's list";
    ListingNotFoundException exception = assertThrows(ListingNotFoundException.class, () -> {
      agent.completeListing(listing2);
    });
    String actualMessage = exception.getMessage();
    assertEquals(expectedMessage, actualMessage);

    // Assert that the listing was completed and removed from the agent's list,
    // and that the agent's total earnings were updated
    assertEquals(0, agent.getListings().size());
    assertEquals(50.05, agent.getTotalEarnings());
  }

  @Test
  public void testDropListing() throws InvalidInputException, ListingNotFoundException {
    // Create an Agent object
    Agent<Commercial, Rental> agent = new Agent<>("test3", new ArrayList<>(), 0.5, 0.0);

    // Create a Listing object
    Listing listing = new Listing(testCommercial, testRental);

    // Add the listing to the agent's list
    agent.addListing(listing);

    // Drop the listing
    agent.dropListing(listing);

    // Assert that the listing was dropped successfully
    assertEquals(0, agent.getListings().size());

    // Assert dropping listing that does not exist
    Listing listing2 = new Listing(testResidential, testRental);
    String expectedMessage = "The listing you wanted to drop is not on the agent's list";
    ListingNotFoundException exception = assertThrows(ListingNotFoundException.class, () -> {
      agent.dropListing(listing2);
    });
    String actualMessage = exception.getMessage();
    assertEquals(expectedMessage, actualMessage);
  }

  @Test
  public void testGetTotalPortfolioValue() throws InvalidInputException {
    // Create an Agent object
    Agent<Commercial, Sale> agent = new Agent<>("test4", new ArrayList<>(), 0.5, 0.0);

    // Create some Listing objects
    Listing listing1 = new Listing(testCommercial, testSale);

    Residential testResidential2 = new Residential("100",31,13,2.5);
    Sale testSale2 = new Sale(111.1,false);
    Listing listing2 = new Listing(testResidential2, testSale2);

    // Add the listings to the agent's list
    agent.addListing(listing1);
    agent.addListing(listing2);
    assertEquals("test4",agent.getName());
    // Assert that the total portfolio value is calculated correctly
    assertEquals(61.10, agent.getTotalPortfolioValue(),0.0001);
  }
  @Test
  void testEquals() throws InvalidInputException {
    Agent<Commercial, Sale> agent1 = new Agent<>("test", new ArrayList<>(), 0.5, 0.0);
    Agent<Commercial, Sale> agent2 = new Agent<>("test", new ArrayList<>(), 0.5, 0.0);
    Agent<Commercial, Sale> agent3 = new Agent<>("test3", new ArrayList<>(), 0.1, 0.0);
    assertTrue(agent2.equals(agent2));
    assertTrue(agent2.equals(agent1));
    assertFalse(agent2.equals(agent3));
    assertFalse("A test String".equals(agent2));
    assertFalse(agent2.equals(null));
  }
  @Test
  void testToString() throws InvalidInputException {
    Agent<Commercial, Sale> agent1 = new Agent<>("test", new ArrayList<>(), 0.5, 0.0);
    assertEquals("Agent{name='test', listings=[], commissionRate=0.5, totalEarnings=0.0}",agent1.toString());
  }

}