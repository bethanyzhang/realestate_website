package problem1;

import java.util.Objects;

/**
 * A class representing a commercial property with an address, size, number of offices, and retail suitability.
 */
public class Commercial extends AbstractProperty {

  /**
   * The number of offices in the commercial property.
   */
  private Integer numOfOffices;
  /**
   * Whether the commercial property is suitable for retail.
   */
  private Boolean isRetailSuitable;
  /**
   * The minimum allowable number of offices for the commercial property.
   */
  private static final Integer MIN_NUM_OF_OFFICES = 0;

  /**
   * Constructs a new Commercial object with the given address, size, number of offices, and retail suitability.
   * @param address the address of the commercial property
   * @param size the size of the commercial property
   * @param numOfOffices the number of offices in the commercial property
   * @param isRetailSuitable whether the commercial property is suitable for retail
   * @throws InvalidInputException if the number of offices is less than 0
   */
  public Commercial(String address, Integer size, Integer numOfOffices, Boolean isRetailSuitable)
      throws InvalidInputException {
    super(address, size);
    if (numOfOffices < MIN_NUM_OF_OFFICES) {
      throw new InvalidInputException("The number of offices must be a non-negative integer.");
    }
    this.numOfOffices = numOfOffices;
    this.isRetailSuitable = isRetailSuitable;
  }

  /**
   * Returns the number of offices in the commercial property.
   * @return the number of offices
   */
  public Integer getNumOfOffices() {
    return numOfOffices;
  }

  /**
   * Returns whether the commercial property is suitable for retail.
   * @return true if the commercial property is suitable for retail, false otherwise
   */
  public Boolean getRetailSuitable() {
    return isRetailSuitable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Commercial that = (Commercial) o;
    return Objects.equals(numOfOffices, that.numOfOffices) && Objects.equals(isRetailSuitable,
        that.isRetailSuitable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numOfOffices, isRetailSuitable);
  }

  @Override
  public String toString() {
    return "Commercial{" +
        "numOfOffices=" + numOfOffices +
        ", isRetailSuitable=" + isRetailSuitable +
        '}';
  }
}
