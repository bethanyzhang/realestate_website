package problem1;

import java.util.Objects;

/**
 * A class representing a rental contract for a property.
 */
public class Rental extends AbstractContract {
  /**
   * The term of the rental contract.
   */
  private Integer term;
  /**
   * The minimum term for a rental contract.
   */
  private static final Integer MIN_TERM = 0;

  /**
   * Constructs a new Rental object with the given asking price, negotiability, and term.
   * @param askingPrice the asking price for the rental
   * @param isNegotiable whether the rental is negotiable or not
   * @param term the term of the rental contract
   * @throws InvalidInputException if the asking price is invalid or if the term is less than MIN_TERM
   */

  public Rental(Double askingPrice, Boolean isNegotiable, Integer term) throws InvalidInputException {
    super(askingPrice, isNegotiable);
    if (term < MIN_TERM) {
      throw new InvalidInputException("Term must be greater than 0");
    }
    this.term = term;
  }

  /**
   * Returns the term of the rental contract.
   * @return
   */
  public Integer getTerm() {
    return term;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Rental rental = (Rental) o;
    return Objects.equals(term, rental.term);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), term);
  }

  @Override
  public String toString() {
    return "Rental{" +
        "term=" + term +
        ", askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        '}';
  }

  public Double getBase() {
    return this.getAskingPrice() * this.getTerm();
  }
}
