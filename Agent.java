package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Agent<T extends AbstractProperty, U extends AbstractContract> {

  private String name;
  private ArrayList<Listing> listings;
  private Double commissionRate;
  private Double totalEarnings;
  private static final int COMMISSION_LOWER_BOUND = 0;
  private static final int COMMISSION_UPPER_BOUND = 1;

  public Agent(String name, ArrayList<Listing> listings, Double commissionRate, Double totalEarnings)
      throws InvalidInputException {
    if (commissionRate < COMMISSION_LOWER_BOUND || commissionRate > COMMISSION_UPPER_BOUND) {
      throw new InvalidInputException("Commission rate must be between 0 and 1");
    }
    this.name = name;
    this.listings = listings;
    this.commissionRate = commissionRate;
    this.totalEarnings = totalEarnings;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Listing> getListings() {
    return listings;
  }

  public Double getCommissionRate() {
    return commissionRate;
  }

  public Double getTotalEarnings() {
    return totalEarnings;
  }

  public void addListing(Listing newListing) {
    this.listings.add(newListing);
  }

  public void completeListing(Listing listingCompleted) throws ListingNotFoundException {
    if(!this.listings.contains(listingCompleted)) {
      throw new ListingNotFoundException("The listing is not on the agent's list");
    }
    else {
      this.listings.remove(listingCompleted);
      double commissionEarned = this.calculateCommission(listingCompleted);
      this.totalEarnings += commissionEarned;
    }
  }

  private Double calculateCommission(Listing listingToCalculate) {
    return this.getCommissionRate() * listingToCalculate.getContract().getBase();
  }
  public void dropListing(Listing listingToDrop) throws ListingNotFoundException {
    if (this.listings.contains(listingToDrop)) {
      this.listings.remove(listingToDrop);
    } else
      throw new ListingNotFoundException("The listing you wanted to drop is not on the agent's list");
  }

  public Double getTotalPortfolioValue() {
    Double totalValue = 0.0;
    for(Listing aListing: listings) {
      totalValue += this.calculateCommission(aListing);
    }
    return totalValue;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Agent<?, ?> agent = (Agent<?, ?>) o;
    return Objects.equals(name, agent.name) && Objects.equals(listings, agent.listings)
        && Objects.equals(commissionRate, agent.commissionRate) && Objects.equals(totalEarnings,
        agent.totalEarnings) && Objects.equals(o.hashCode(),agent.hashCode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, listings, commissionRate, totalEarnings);
  }

  @Override
  public String toString() {
    return "Agent{" +
        "name='" + name + '\'' +
        ", listings=" + listings +
        ", commissionRate=" + commissionRate +
        ", totalEarnings=" + totalEarnings +
        '}';
  }
}