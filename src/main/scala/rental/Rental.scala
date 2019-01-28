package rental

/**
  * Rental defines a common interface to calculate the total cost of a determined rental type.
  */
trait Rental {

  /**
    * Calculates the cost of the rental.
    * @return the total costs of the rental.
    */
  def total() : BigDecimal

}
