package rental.impl

import rental.{PricingConstants, Rental}

/**
  * Rental implementation for Weekly rentals.
  * @param weeks of rent.
  */
class WeeklyRental(val weeks: Int) extends Rental {

  override def total(): BigDecimal = PricingConstants.WEEK_PRICE * weeks

}
