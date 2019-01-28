# Bike-Rental

The Rental model is represented by a single trait "Rental" which defines an interface to calculate
the total spend of a determined rental, then all the implementations overrides the total method
defining a particular calculation, all the structure implements the Composite Pattern to allow the 
composition of Leaf objects (Hourly, Daily, Weekly) which just allow to calculate the cost of a 
determined bike usage based on the time and the Composite object (Family Package) to allow 
combining different types into a package to apply a determined discount. All prices and discounts 
are defined into the PricingConstants object to hold that configuration in a centralized way 
that could be configured in the future.

#

To run automated tests:

```
sbt clean test
```

To run tests with coverage:

```
sbt clean coverage test
# Then generate report 
sbt coverageReport
```

This will generate a report on **"./target/scala-\<version\>/scoverage-report/index.html"** 
open with any browser to check out the report.