package rental.impl

import rental.{PricingConstants, Rental}

/**
  * Rental implementation for Daily rentals.
  * @param days of rent.
  */
class DailyRental(val days: Int) extends Rental {

  override def total(): BigDecimal = PricingConstants.DAY_PRICE * days

}
