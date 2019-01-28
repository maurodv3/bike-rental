package rental.impl

import rental.{PricingConstants, Rental}

/**
  * Rental implementation for Hour rentals.
  * @param hours of rent.
  */
class HourlyRental(val hours: Int) extends Rental {

  override def total(): BigDecimal = PricingConstants.HOUR_PRICE * hours

}
