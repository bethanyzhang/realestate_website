package problem1;

import java.util.Objects;

/**
 * A class that represents a residential property with its characteristics.
 */
public class Residential extends AbstractProperty {

  /**
   * The number of bedrooms in the residential property.
   */
  private Integer numOfBedrooms;
  /**
   *  The number of bathrooms in the residential property.
   */
  private Double numOfBathrooms;
  /**
   * The minimum allowed number of bedrooms.
   */
  private static final Integer MIN_NUM_OF_BEDROOMS = 0;
  /**
   * The minimum allowed number of bathrooms.
   */
  private static final Integer MIN_NUM_OF_BATHROOMS = 0;

  /**
   * Constructs a new residential property with the specified address, size,
   * number of bedrooms, and number of bathrooms.
   * @param address The address of the residential property.
   * @param size The size of the residential property.
   * @param numOfBedrooms The number of bedrooms in the residential property.
   * @param numOfBathrooms The number of bathrooms in the residential property.
   * @throws InvalidInputException If the number of bedrooms or bathrooms is negative.
   */

  public Residential(String address, Integer size, Integer numOfBedrooms, Double numOfBathrooms)
      throws InvalidInputException {
    super(address, size);
    if (numOfBedrooms < MIN_NUM_OF_BEDROOMS || numOfBathrooms < MIN_NUM_OF_BATHROOMS) {
      throw new InvalidInputException("The number of bedrooms and bathrooms must be a non-negative integer.");
    }
    this.numOfBedrooms = numOfBedrooms;
    this.numOfBathrooms = numOfBathrooms;
  }

  /**
   * Returns the number of bedrooms in the residential property.
   * @return The number of bedrooms in the residential property.
   */
  public Integer getNumOfBedrooms() {
    return numOfBedrooms;
  }

  /**
   * Returns the number of bathrooms in the residential property.
   * @return the number of bathrooms in the residential property.
   */
  public Double getNumOfBathrooms() {
    return numOfBathrooms;
  }


  @Override
  public String toString() {
    return "Residential{" +
        "numOfBedrooms=" + numOfBedrooms +
        ", numOfBathrooms=" + numOfBathrooms +
        ", address='" + address + '\'' +
        ", size=" + size +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Residential that = (Residential) o;
    return Objects.equals(numOfBedrooms, that.numOfBedrooms) && Objects.equals(numOfBathrooms,
        that.numOfBathrooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numOfBedrooms, numOfBathrooms);
  }
}
