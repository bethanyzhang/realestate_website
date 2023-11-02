package problem1;

/**
 * A class representing a sale contract for a property.
 */
public class Sale extends AbstractContract {

  /**
   *  Constructs a Sale object with the specified asking price and negotiability.
   * @param askingPrice the asking price for the sale
   * @param isNegotiable whether the rental is negotiable or not
   * @throws InvalidInputException if the asking price is less than 0
   */
  public Sale(Double askingPrice, Boolean isNegotiable) throws InvalidInputException {
    super(askingPrice, isNegotiable);
  }

  @Override
  public String toString() {
    return "Sale{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        '}';
  }

  public Double getBase() {
    return this.getAskingPrice();
  }
}
