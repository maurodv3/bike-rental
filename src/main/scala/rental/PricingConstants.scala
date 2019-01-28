package rental

/**
  * Helper class to hold constants prices and discounts for Rental types.
  * All BigDecimal parameters are Strings to avoid precision loss from Double conversion.
  */
object PricingConstants {

  /**
    * Pricing per hour.
    */
  val HOUR_PRICE: BigDecimal = BigDecimal.exact("5")

  /**
    * Pricing per day.
    */
  val DAY_PRICE: BigDecimal = BigDecimal.exact("20")

  /**
    * Pricing per week.
    */
  val WEEK_PRICE: BigDecimal = BigDecimal.exact("60")

  /**
    * Family discount coefficient.
    */
  val FAMILY_DISCOUNT: BigDecimal = BigDecimal.exact("0.7")

}
