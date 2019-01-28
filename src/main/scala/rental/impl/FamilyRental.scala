package rental.impl

import java.util.Objects

import rental.{PricingConstants, Rental}

// TODO - By implementing Rental here, we are allowing to contain more family rentals which might not be desired, since would be applying multiple discounts.

/**
  *
  * Rental implementation for Promotion Family Rental.
  *
  * Accepts a minimum of 3 different rental packages up-to a maximum of 5 rentals.
  * It applies a discount of the total price based on the [[PricingConstants.FAMILY_DISCOUNT]].
  *
  * @param firstRental package
  * @param secondRental package
  * @param thirdRental package
  */
class FamilyRental(firstRental: Rental, secondRental: Rental, thirdRental: Rental) extends Rental {

  private var rentals: List[Rental] = List.newBuilder
    .+=(Objects.requireNonNull(firstRental))
    .+=(Objects.requireNonNull(secondRental))
    .+=(Objects.requireNonNull(thirdRental))
    .result()

  /**
    * It sums all the contained rentals and applies a discount coefficient to the total.
    * @return the total costs of the rental.
    */
  override def total(): BigDecimal = rentals.map(rental => rental.total()).sum * PricingConstants.FAMILY_DISCOUNT

  /**
    * Add a new rental into the package.
    * @param rental to add into the package
    * @throws RuntimeException if the Limit is reached
    */
  def addRental(rental: Rental): Unit = {
    if (rentals.size >= 5) {
      throw new RuntimeException("Max number of rentals exceeded.")
    } else {
      rentals = List.newBuilder
        .++=(rentals)
        .+=(Objects.requireNonNull(rental))
        .result()
    }
  }

}
