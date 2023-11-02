package problem1;

import java.util.Objects;

/**
 * An abstract base class for a contract with an asking price and negotiability status.
 */

public abstract class AbstractContract {

  /**
   * The asking price for the contract.
   */
  protected Double askingPrice;
  /**
   * the price is negotiable or not.
   */
  protected Boolean isNegotiable;
  /**
   * The minimum allowable asking price for the contract.
   */
  private static final Double MIN_ASKING_PRICE = 0.0;

  protected abstract Double getBase();

  /**
   * Constructs a new AbstractContract object with the given asking price and negotiability status.
   * @param askingPrice the asking price for the contract
   * @param isNegotiable the price is negotiable or not.
   * @throws InvalidInputException if the asking price is less than 0.
   */

  public AbstractContract(Double askingPrice, Boolean isNegotiable) throws InvalidInputException {
    if (askingPrice < MIN_ASKING_PRICE) {
      throw new InvalidInputException("The asking price should be greater than 0");
    }
    this.askingPrice = askingPrice;
    this.isNegotiable = isNegotiable;
  }

  /**
   * Returns the asking price for the contract.
   * @return the asking price
   */
  public Double getAskingPrice() {
    return askingPrice;
  }

  /**
   * Returns the negotiability status of the contract.
   * @return the price is negotiable or not.
   */
  public Boolean getNegotiable() {
    return isNegotiable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractContract contract = (AbstractContract) o;
    return Objects.equals(askingPrice, contract.askingPrice) && Objects.equals(isNegotiable,
        contract.isNegotiable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(askingPrice, isNegotiable);
  }
}
