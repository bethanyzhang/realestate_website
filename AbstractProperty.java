package problem1;

import java.util.Objects;

/**
 * An abstract base class for a property with an address and size.
 */

public abstract class AbstractProperty {

  /**
   * The address of the property.
   */
  protected String address;
  /**
   * The size of the property.
   */
  protected Integer size;
  /**
   * The minimum allowable size for the property.
   */
  private static final Integer MIN_SIZE = 0;


  /**
   * Constructs a new AbstractProperty object with the given address and size.
   * @param address the address of the property
   * @param size the size of the property
   * @throws InvalidInputException if the size is less than 0
   */
  public AbstractProperty(String address, Integer size) throws InvalidInputException {
    if (size < MIN_SIZE) {
      throw new InvalidInputException("Size must be a non-negative integer.");
    }
    this.address = address;
    this.size = size;
  }

  /**
   * Returns the address of the property.
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Returns the size of the property.
   * @return the size
   */
  public Integer getSize() {
    return size;
  }

}
