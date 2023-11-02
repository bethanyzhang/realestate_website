package problem1;

import java.util.Objects;

/**
 * A class representing a property listing with a property and a contract.
 * @param <P> the type of property that this listing contains
 * @param <C> the type of contract that this listing contains
 */

public class Listing<P extends AbstractProperty, C extends AbstractContract> {

  /**
   * The property associated with this listing.
   */
  private P property;
  /**
   * The contract associated with this listing.
   */
  private C contract;

  /**
   * Constructs a new Listing object with the given property and contract.
   * @param property the property to be listed
   * @param contract the contract associated with the listing
   */
  public Listing(P property, C contract) {
    this.property = property;
    this.contract = contract;
  }

  /**
   * Returns the property associated with this listing.
   * @return the property
   */
  public P getProperty() {
    return property;
  }

  /**
   * Returns the contract associated with this listing.
   * @return the contract
   */
  public C getContract() {
    return contract;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Listing<?, ?> listing = (Listing<?, ?>) o;
    return Objects.equals(property, listing.property) && Objects.equals(contract, listing.contract);
  }

  @Override
  public int hashCode() {
    return Objects.hash(property, contract);
  }

  @Override
  public String toString() {
    return "Listing{" +
        "property=" + property +
        ", contract=" + contract +
        '}';
  }
}
