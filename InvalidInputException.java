package problem1;

/**
 * An exception indicating that the input given to a method is invalid.
 */
public class InvalidInputException extends Throwable {

  /**
   * Constructs a new InvalidInputException with the given message.
   * @param s the message describing the invalid input
   */

  public InvalidInputException(String s) {
    super(s);
  }
}
