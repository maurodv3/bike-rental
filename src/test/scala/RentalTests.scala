import org.scalatest._
import rental.{PricingConstants, Rental}
import rental.impl.{DailyRental, FamilyRental, HourlyRental, WeeklyRental}

class RentalTests extends FlatSpec with Matchers {

  private val hours = 2
  private val days = 2
  private val weeks = 2
  private val hourlyRental = new HourlyRental(hours)
  private val dailyRental = new DailyRental(days)
  private val weeklyRental = new WeeklyRental(weeks)

  def checkTotal(rental: Rental, timeRange: Int, price: BigDecimal) : Unit = {
    rental.total() should be (timeRange * price)
  }

  "A Hourly rental" should "return a total result calculated as number of hours * hour price." in {
    checkTotal(hourlyRental, hours, PricingConstants.HOUR_PRICE)
  }

  "A Daily rental" should "return a total result calculated as number of days * daily price." in {
    checkTotal(dailyRental, days, PricingConstants.DAY_PRICE)
  }

  "A Weekly rental" should "return a total result calculated as number of weeks * week price." in {
    checkTotal(weeklyRental, weeks, PricingConstants.WEEK_PRICE)
  }

  "A Family rental" should "return a total result calculated as the sum of it's contained rentals minus the discount" in {
    val familyRental = new FamilyRental(hourlyRental, dailyRental, weeklyRental)
    val threeHourRental = new HourlyRental(3)
    familyRental.addRental(threeHourRental)
    val rentalSum = hourlyRental.total() + dailyRental.total() + weeklyRental.total() + threeHourRental.total()
    familyRental.total() should be (rentalSum * PricingConstants.FAMILY_DISCOUNT)
  }

  it should "throw a NPE if any rental is null" in {
    a [NullPointerException] should be thrownBy {
      new FamilyRental(null, hourlyRental, weeklyRental)
    }
  }

  it should "throw a NPE if adding rental is null" in {
    a [NullPointerException] should be thrownBy {
      val familyRental = new FamilyRental(dailyRental, hourlyRental, weeklyRental)
      familyRental.addRental(null)
    }
  }

  it should "throw a RuntimeException if adding rental exceeds 5 rentals" in {
    a [RuntimeException] should be thrownBy {
      val familyRental = new FamilyRental(dailyRental, hourlyRental, weeklyRental)
      familyRental.addRental(new DailyRental(2))
      familyRental.addRental(new WeeklyRental(2))
      familyRental.addRental(new HourlyRental(2))
    }
  }
}