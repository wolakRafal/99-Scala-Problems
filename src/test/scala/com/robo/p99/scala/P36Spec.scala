package com.robo.p99.scala

import org.p99.scala.UnitSpec


/**
 * P36 (medium)

Determine the prime factors of a given positive integer (2). Construct a list
containing the prime factors and their multiplicity.
Example:

    scala> primeFactorMultiplicity(315)
    res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)
 */
class P36Spec extends UnitSpec {

  "primeFactorMultiplicity(315)" should "return " in {
    assert(P36.primeFactorMultiplicity(315) === Map(3 -> 2, 5 -> 1, 7 -> 1))
  }

}

